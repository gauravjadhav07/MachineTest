package com.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.DTO.RequestCategory;
import com.DTO.ResponseCategory;
import com.Entity.Category;
import com.Exception.CategoryNotFoundException;
import com.Repository.CategoryRepo;
import com.Service.CategoryService;

@Service
public class CategoryServiceIMPL implements CategoryService {

  @Autowired
  private CategoryRepo categoryRepository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public ResponseCategory createCategory(RequestCategory request) {
    Category category = new Category();
    category.setCategoryName(request.getCategoryName());
    Category saved = categoryRepository.save(category);
    return modelMapper.map(saved, ResponseCategory.class);
  }

  @Override
  public List<ResponseCategory> getAllCategories(int page, int size) {
    return categoryRepository.findAll(PageRequest.of(page, size))
      .stream()
      .map(cat -> modelMapper.map(cat, ResponseCategory.class))
      .collect(Collectors.toList());
  }

  @Override
  public ResponseCategory getCategoryById(Long id) {
    Category category = categoryRepository.findById(id)
      .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    return modelMapper.map(category, ResponseCategory.class);
  }

  @Override
  public ResponseCategory updateCategory(Long id, RequestCategory request) {
    Category category = categoryRepository.findById(id)
      .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

    category.setCategoryName(request.getCategoryName());
    Category updated = categoryRepository.save(category);
    return modelMapper.map(updated, ResponseCategory.class);
  }

  @Override
  public String deleteCategory(Long id) {
    Category category = categoryRepository.findById(id)
      .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

    categoryRepository.delete(category);
    return "Category deleted successfully";
  }
}
