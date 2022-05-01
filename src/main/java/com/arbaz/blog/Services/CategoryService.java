package com.arbaz.blog.Services;

import com.arbaz.blog.DTO.CategoryDTO;
import java.util.List;

public interface CategoryService {

    //create
    public CategoryDTO CreateCategory(CategoryDTO categoryDTO);

    //update
    public CategoryDTO UpdateCategory(CategoryDTO categoryDTO,int categoryId);

    //delete
    public void DeleteCategory(int categoryId);

    //deleteAllCategories
    public void DeleteAllCategories();

    //get
    public CategoryDTO getCategory(int categoryId);

    //getAll
    public List<CategoryDTO> getAllCategory();
}
