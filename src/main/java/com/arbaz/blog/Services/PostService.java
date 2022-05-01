package com.arbaz.blog.Services;

import com.arbaz.blog.DTO.APIResponse;
import com.arbaz.blog.DTO.PostDTO;
import com.arbaz.blog.DTO.PostResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    //Create Post
    public PostDTO createPost(PostDTO postDTO,int userId,int categoryId);

    //Update Post
    public PostDTO UpdatePost(PostDTO postDTO,int postId);

    //GetAllPost
    public PostDTO GetPostById(int postId);

    //GetPostById
    public PostResponse GetAllPost(Integer pageNumber , Integer pageSize,String sortBy,String sortDirection);

    //Get All Post By Category
    public List<PostDTO> GetPostByCategory(int postId);

    //Get Post By UserId
    public List<PostDTO> GetPostByUser(int postId);

    //Delete Post
    public ResponseEntity<?> DeletePostById(int postId);

    //Delete All Post
    public ResponseEntity<?> DeleteAllPost();

    //Search Post
    List<PostDTO> SearchPost(String keyword);

}
