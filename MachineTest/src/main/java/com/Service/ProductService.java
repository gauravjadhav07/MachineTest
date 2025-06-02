package com.Service;

import java.util.List;

import com.DTO.RequestProduct;
import com.DTO.ResponseProduct;

public interface ProductService {
  ResponseProduct createProduct(RequestProduct request);
  List<ResponseProduct> getAllProducts(int page, int size);
  ResponseProduct getProductById(Long id);
  ResponseProduct updateProduct(Long id, RequestProduct request);
  String deleteProduct(Long id);
}
