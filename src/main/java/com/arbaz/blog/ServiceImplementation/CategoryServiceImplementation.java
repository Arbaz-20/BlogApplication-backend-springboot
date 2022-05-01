package com.arbaz.blog.ServiceImplementation;

import com.arbaz.blog.DTO.CategoryDTO;
import com.arbaz.blog.Entity.Category;
import com.arbaz.blog.Exceptions.ResourceNotFoundException;
import com.arbaz.blog.Repository.CategoryRepository;
import com.arbaz.blog.Services.CategoryService;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO CreateCategory(CategoryDTO categoryDTO) {

        Category category = this.modelMapper.map(categoryDTO , Category.class);
        Category cat = this.categoryRepository.save(category);
        return this.modelMapper.map(cat,CategoryDTO.class);

    }

    @Override
    public CategoryDTO UpdateCategory(CategoryDTO categoryDTO, int categoryId) {

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category id",categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        Category updatedCategory = this.categoryRepository.save(category);
        return this.modelMapper.map(updatedCategory,CategoryDTO.class);

    }

    @Override
    public void DeleteCategory(int categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public void DeleteAllCategories() {
        this.categoryRepository.deleteAll();
    }

    @Override
    public CategoryDTO getCategory(int categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
        return this.modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map((category) -> this.modelMapper.map(category,CategoryDTO.class)).collect(Collectors.toList());
        return categoryDTOS;
    }

}
