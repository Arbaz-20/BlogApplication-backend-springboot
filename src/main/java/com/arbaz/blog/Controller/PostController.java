package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.PostDTO;
import com.arbaz.blog.DTO.PostResponse;
import com.arbaz.blog.Services.FileService;
import com.arbaz.blog.Services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;


    //We can use the Image post Mapping with this aswell its all depends what we think of coding
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

    //Get Post by keyword or Keyword
    @GetMapping("/posts/{keyword}")
    public ResponseEntity<List<PostDTO>> SearchPostByTitle(@PathVariable("keyword") String keyword){
        List<PostDTO> post = this.postService.SearchPost(keyword);
        return new ResponseEntity<List<PostDTO>>(post,HttpStatus.FOUND);
    }

    //Image Name save in Database with the image save in images folder
    //Create Post with the Image
    @PostMapping(value = "/image/upload/{postId}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<PostDTO> PostImage(@PathVariable("postId") Integer postId,@RequestParam("image") MultipartFile file) throws IOException {
        PostDTO postDTO = this.postService.GetPostById(postId);
        String FileName = this.fileService.UploadImage(path,file);
        postDTO.setImageName(FileName);
        PostDTO updatePost = this.postService.UpdatePost(postDTO,postId);
        return new ResponseEntity<PostDTO>(updatePost,HttpStatus.OK);
    }


    //Get Image from the folder
    @GetMapping(value = "/profile/{ImageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void DownloadImage(@PathVariable("ImageName") String ImageName, HttpServletResponse response) throws IOException {
        InputStream resource = this.fileService.getResource(path,ImageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());

    }
}
