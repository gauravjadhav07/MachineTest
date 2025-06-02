package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.DTO.*;
import com.Service.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public List<ResponseCategory> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
    return categoryService.getAllCategories(page, size);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseCategory createCategory(@RequestBody RequestCategory request) {
    return categoryService.createCategory(request);
  }

  @GetMapping("/{id}")
  public ResponseCategory getCategoryById(@PathVariable Long id) {
    return categoryService.getCategoryById(id);
  }

  @PutMapping("/{id}")
  public ResponseCategory updateCategory(@PathVariable Long id, @RequestBody RequestCategory request) {
    return categoryService.updateCategory(id, request);
  }

  @DeleteMapping("/{id}")
  public String deleteCategory(@PathVariable Long id) {
    return categoryService.deleteCategory(id);
  }
}
