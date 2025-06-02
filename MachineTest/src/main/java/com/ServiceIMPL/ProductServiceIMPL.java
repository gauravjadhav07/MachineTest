package com.ServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.DTO.*;
import com.Entity.*;
import com.Exception.*;
import com.Repository.*;
import com.Service.*;

@Service
public class ProductServiceIMPL implements ProductService {

  @Autowired
  private ProductRepo productRepository;

  @Autowired
  private CategoryRepo categoryRepository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public ResponseProduct createProduct(RequestProduct request) {
    
    Category category = categoryRepository.findByCategoryNameIgnoreCase(request.getCategoryName())
      .orElseThrow(() -> new CategoryNotFoundException("Category not found with name: " + request.getCategoryName()));

    Product product = new Product();
    product.setProductName(request.getProductName());
    product.setProductType(request.getProductType());
    product.setCategory(category);

    Product saved = productRepository.save(product);
    ResponseProduct response = modelMapper.map(saved, ResponseProduct.class);

   
    ResponseCategory catResp = modelMapper.map(category, ResponseCategory.class);
    response.setCategory(catResp);

    return response;
  }

  @Override
  public List<ResponseProduct> getAllProducts(int page, int size) {
    return productRepository.findAll(PageRequest.of(page, size))
      .stream()
      .map(product -> {
        ResponseProduct resp = modelMapper.map(product, ResponseProduct.class);
        resp.setCategory(modelMapper.map(product.getCategory(), ResponseCategory.class));
        return resp;
      })
      .collect(Collectors.toList());
  }

  @Override
  public ResponseProduct getProductById(Long id) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    ResponseProduct resp = modelMapper.map(product, ResponseProduct.class);
    resp.setCategory(modelMapper.map(product.getCategory(), ResponseCategory.class));
    return resp;
  }

  @Override
  public ResponseProduct updateProduct(Long id, RequestProduct request) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

    
    Category category = categoryRepository.findByCategoryNameIgnoreCase(request.getCategoryName())
      .orElseThrow(() -> new CategoryNotFoundException("Category not found with name: " + request.getCategoryName()));

    product.setProductName(request.getProductName());
    product.setProductType(request.getProductType());
    product.setCategory(category);

    Product updated = productRepository.save(product);
    ResponseProduct resp = modelMapper.map(updated, ResponseProduct.class);
    resp.setCategory(modelMapper.map(category, ResponseCategory.class));
    return resp;
  }

  @Override
  public String deleteProduct(Long id) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    productRepository.delete(product);
    return "Product deleted successfully";
  }
}
