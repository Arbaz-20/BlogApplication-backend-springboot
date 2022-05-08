package com.arbaz.blog.DTO;

import com.arbaz.blog.Entity.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {

    private int postId;

    @NotBlank(message = "Please Enter Title")
    private String title;

    @NotBlank(message = "Please Enter Content")
    private String content;

    private Date date;

    private String imageName;

    private CategoryDTO category;

    private UserDTO user;

    private Set<CommentDTO> comments = new HashSet<>();


}
