package com.arbaz.blog.DTO;

import com.arbaz.blog.Entity.Category;
import com.arbaz.blog.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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


}
