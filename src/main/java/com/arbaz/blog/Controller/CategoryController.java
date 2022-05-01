package com.arbaz.blog.Controller;

import com.arbaz.blog.DTO.CategoryDTO;
import com.arbaz.blog.Services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;


@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Create
    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> CreateCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO category = this.categoryService.CreateCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(category, HttpStatus.CREATED);
    }

    //Update
    @PutMapping("category/{id}")
    public ResponseEntity<CategoryDTO> UpdateCategory(@Valid @PathVariable("id") int categoryId , @RequestBody CategoryDTO categoryDTO){
        CategoryDTO categoryDTO1 = this.categoryService.UpdateCategory(categoryDTO,categoryId);
        return new ResponseEntity<CategoryDTO>(categoryDTO1,HttpStatus.OK);
    }

    //Get
    @GetMapping("/getCategory/{id}")
    public ResponseEntity<CategoryDTO> GetUserById(@Valid @PathVariable("id") int categoryId){
        CategoryDTO categoryDTO = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<CategoryDTO>(categoryDTO,HttpStatus.OK);
    }

    //GetAll
    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryDTO>> GetAllCategories(){
        List<CategoryDTO> categoryDTOList = this.categoryService.getAllCategory();
        return new ResponseEntity<List<CategoryDTO>>(categoryDTOList,HttpStatus.OK);
    }


    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteCategoryById(@Valid @PathVariable("id") int categoryId){
        this.categoryService.DeleteCategory(categoryId);
        String message = "Deleted Category Successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    //DeleteAll
    @DeleteMapping("/delete")
    public ResponseEntity<?> DeleteAllCategory(){
        this.categoryService.DeleteAllCategories();
        String message = "Deleted All Categories";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
