package com.Service;

import java.util.List;

import com.DTO.RequestCategory;
import com.DTO.ResponseCategory;

public interface CategoryService {
  ResponseCategory createCategory(RequestCategory request);
  List<ResponseCategory> getAllCategories(int page, int size);
  ResponseCategory getCategoryById(Long id);
  ResponseCategory updateCategory(Long id, RequestCategory request);
  String deleteCategory(Long id);
}
