package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.APIResponse;
import com.arbaz.blog.DTO.CommentDTO;
import com.arbaz.blog.Services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDTO> CreateComment(@RequestBody CommentDTO commentDTO, @PathVariable("postId") int postId){
        CommentDTO commentDTO1 = this.commentService.CreateComment(commentDTO,postId);
        return new ResponseEntity<CommentDTO>(commentDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/comment/{commentId}")
    public ResponseEntity<APIResponse> deleteComment(@PathVariable("commentId") int commentId){
        this.commentService.DeleteComment(commentId);
        return new ResponseEntity<APIResponse>(new APIResponse("Comment Successfully Deleted",true),HttpStatus.OK);
    }
}
