package com.cdac.controllers;

import com.cdac.dtos.CategoryDTO;
import com.cdac.services.CategoryService;
import com.cdac.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    ResponseEntity<ApiResponse<CategoryDTO>> handleCreateCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        System.out.println(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<CategoryDTO>builder().body(categoryService.insertCategory(categoryDTO)).success(true).message("Category created successfully!").build());
    }

    @GetMapping
    ResponseEntity<ApiResponse<List<CategoryDTO>>> handleAllCategories() {
        return ResponseEntity.ok(ApiResponse.<List<CategoryDTO>>builder().body(categoryService.getAllCategories()).success(true).message("Fetched all categories!").build());
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<CategoryDTO>> handleSingleCategory(@PathVariable long id) {
        return ResponseEntity.ok(ApiResponse.<CategoryDTO>builder().body(categoryService.getCategoryById(id)).success(true).message("Fetched category with id: " + id).build());
    }

    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<CategoryDTO>> handleUpdateCategory(@PathVariable long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(ApiResponse.<CategoryDTO>builder().body(categoryService.updateCategory(id, categoryDTO)).success(true).message("Category updated successfully!").build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<CategoryDTO>> handleDeleteCategory(@PathVariable long id) {
        return ResponseEntity.ok(ApiResponse.<CategoryDTO>builder().body(categoryService.deleteCategory(id)).success(true).message("Category deleted successfully!").build());
    }

}
