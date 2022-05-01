package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.PostDTO;
import com.arbaz.blog.DTO.PostResponse;
import com.arbaz.blog.Entity.Post;
import com.arbaz.blog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    //Create Post
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO>CreatePost(@RequestBody PostDTO postDTO, @PathVariable("userId") int userId,@PathVariable("categoryId") int categoryId){
        PostDTO post = this.postService.createPost(postDTO,userId,categoryId);
        return new ResponseEntity<PostDTO>(post,HttpStatus.CREATED);
    }

    //Update Post
    @PutMapping("/update/{postId}")
    public ResponseEntity<PostDTO> UpdatePost(@Valid @RequestBody PostDTO postDTO , @PathVariable("postId") int postId){
        PostDTO post = this.postService.UpdatePost(postDTO,postId);
        return new ResponseEntity<PostDTO>(post,HttpStatus.OK);
    }

    //Get Post By User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>>GetPostByUser(@PathVariable("userId") int userId){
        List<PostDTO> postDTOS=this.postService.GetPostByUser(userId);
        return new ResponseEntity<List<PostDTO>>(postDTOS,HttpStatus.OK);

    }

    //Get Post by Category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> GetPostByCategory(@PathVariable("categoryId") int categoryId){
        List<PostDTO> posts = this.postService.GetPostByCategory(categoryId);
        return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
    }

    //Get All Post
    @GetMapping("/getAllPost")
    public ResponseEntity<PostResponse> GetAllPost(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                                   @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize,
                                                   @RequestParam(value = "sortBy",defaultValue = "postId",required = false) String sortBy,
                                                   @RequestParam(value = "sortDirection",defaultValue = "ascending",required = false) String sortDirection){
        PostResponse postResponse = this.postService.GetAllPost(pageNumber,pageSize,sortBy,sortDirection);
        return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
    }

    //Get Post by ID
    @GetMapping("/getPost/{postId}")
    public ResponseEntity<PostDTO> GetPostById(@PathVariable("postId") int postId){
        PostDTO postDTO = this.postService.GetPostById(postId);
        return new ResponseEntity<PostDTO>(postDTO,HttpStatus.OK);
    }

    //Delete Post by ID
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> DeleteById( @PathVariable("postId") int postId){
        this.postService.DeletePostById(postId);
        String message = "Post Deleted Successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    //Delete All By Post
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> DeleteAllPost(){
        this.postService.DeleteAllPost();
        String message = "All Post Deleted Successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/posts/{keyword}")
    public ResponseEntity<List<PostDTO>> SearchPostByTitle(@PathVariable("keyword") String keyword){
        List<PostDTO> post = this.postService.SearchPost(keyword);
        return new ResponseEntity<List<PostDTO>>(post,HttpStatus.FOUND);
    }
}
