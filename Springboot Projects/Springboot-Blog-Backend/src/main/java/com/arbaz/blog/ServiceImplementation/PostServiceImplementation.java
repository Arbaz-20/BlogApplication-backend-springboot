package com.arbaz.blog.ServiceImplementation;

import com.arbaz.blog.DTO.PostDTO;
import com.arbaz.blog.DTO.PostResponse;
import com.arbaz.blog.Entity.Category;
import com.arbaz.blog.Entity.Post;
import com.arbaz.blog.Entity.User;
import com.arbaz.blog.Exceptions.PropertyResponseException;
import com.arbaz.blog.Exceptions.ResourceNotFoundException;
import com.arbaz.blog.Repository.CategoryRepository;
import com.arbaz.blog.Repository.PostRepository;
import com.arbaz.blog.Repository.UserRepository;
import com.arbaz.blog.Services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    //Create Post
    @Override
    public PostDTO createPost(PostDTO postDTO, int userId, int categoryId) {

        //User Details
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","UserId",userId));

        //Category Details
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));

        //CreatingPost
        Post post = this.modelMapper.map(postDTO,Post.class);
        post.setImageName(postDTO.getImageName());
        post.setDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post savePost = this.postRepository.save(post);

        //Returning the Created Post
        return this.modelMapper.map(savePost,PostDTO.class);
    }



    //Update Post
    @Override
    public PostDTO UpdatePost(PostDTO postDTO, int postId) {

        //Updating Post
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId",postId));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImageName(postDTO.getImageName());
        post.setDate(new Date());
        Post savePost = this.postRepository.save(post);

        //Returning Updated Post
        return this.modelMapper.map(savePost,PostDTO.class);
    }



    //Getting Post by ID
    @Override
    public PostDTO GetPostById(int postId) {

        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId",postId));
        PostDTO postDTO = this.modelMapper.map(post,PostDTO.class);

        return postDTO;
    }



    //Getting All Post
    @Override
    public PostResponse GetAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDirection) {

        //Ternary Operator in Sorting the data
        Sort sort = null;
        try{
            sort = (sortDirection.equalsIgnoreCase("ascending")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        }
        catch(PropertyResponseException e){
            new PropertyResponseException(e.getMessage());
        }


        //Make Pageable First
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);

        //Get All post in Page Object
        Page<Post> pagePost = this.postRepository.findAll(pageable);

        //Get all the List of Content from the page
        List<Post> allPost = pagePost.getContent();

        List<PostDTO> posts = allPost.stream().map((post)->this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());
        if(posts.isEmpty()){
            new ResourceNotFoundException().setResourceName("Didn't Have any Post");
        }
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(posts);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());
        return postResponse;
    }




    //Getting All Post By Category
    @Override
    public List<PostDTO> GetPostByCategory(int categoryId) {

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        List<Post> posts = this.postRepository.findByCategory(category);

        //Convert from Post to PostDTOS
        List<PostDTO> postDTOS = posts.stream().map((post)->this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());

        return postDTOS;
    }




    //Getting All Post by User
    @Override
    public List<PostDTO> GetPostByUser(int userId) {

        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));
        List<Post> posts = this.postRepository.findByUser(user);

        //Convert from Post to PostDTOS
        List<PostDTO> postDTOS = posts.stream().map((post)->this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());

        return postDTOS;
    }



    //Delete Post by Id
    @Override
    public ResponseEntity<?> DeletePostById(int postId) {

        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId",postId));
        this.postRepository.delete(post);
        String message = "Post Deleted Successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }



    //Delete All Post
    @Override
    public ResponseEntity<?> DeleteAllPost(){
        this.postRepository.deleteAll();
        String message = "Deleted All Post Successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }



    //Search Post by Keyword
    @Override
    public List<PostDTO> SearchPost(String keyword) {
        List<Post> posts = this.postRepository.SearchByKeyword("%"+keyword+"%");
        List<PostDTO> postDTOS = posts.stream().map((post -> this.modelMapper.map(post,PostDTO.class))).collect(Collectors.toList());
        return postDTOS;
    }


    public Post DTOtoPost(PostDTO postDTO){
        Post post = this.modelMapper.map(postDTO,Post.class);
        return post;
    }

    public PostDTO PostTOPostDTO(Post post){
        PostDTO postDTO = this.modelMapper.map(post,PostDTO.class);
        return postDTO;
    }
}
