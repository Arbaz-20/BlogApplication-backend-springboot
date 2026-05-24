package com.arbaz.blog.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private int categoryId;

    @NotBlank(message = "Please Enter the Category")
    @Size(min = 5,message = "Atleast provide 5 inputs")
    private String CategoryTitle;

    @NotBlank(message = "Please Enter Category Description")
    @Size(min = 5,message = "Please Enter atleast 5 inputs")
    private String CategoryDescription;
}
