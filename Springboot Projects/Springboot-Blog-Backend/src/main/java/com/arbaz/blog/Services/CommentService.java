package com.arbaz.blog.Services;

import com.arbaz.blog.DTO.CommentDTO;

public interface CommentService {

    public CommentDTO CreateComment(CommentDTO commentDTO,Integer postId);

    public void DeleteComment(Integer commentId);
}
