package com.arbaz.blog.ServiceImplementation;

import com.arbaz.blog.DTO.CommentDTO;
import com.arbaz.blog.Entity.Comment;
import com.arbaz.blog.Entity.Post;
import com.arbaz.blog.Exceptions.ResourceNotFoundException;
import com.arbaz.blog.Repository.CommentRepository;
import com.arbaz.blog.Repository.PostRepository;
import com.arbaz.blog.Services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDTO CreateComment(CommentDTO commentDTO, Integer postId) {

        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","post Id",postId));
        Comment comment = this.modelMapper.map(commentDTO,Comment.class);
        comment.setPost(post);
        Comment saveComment = this.commentRepository.save(comment);

        return this.modelMapper.map(saveComment,CommentDTO.class);
    }

    @Override
    public void DeleteComment(Integer commentId) {
        Comment com = this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment","comment",commentId));
        this.commentRepository.delete(com);
    }
}
