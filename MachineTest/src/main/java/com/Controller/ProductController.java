package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.DTO.*;
import com.Service.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<ResponseProduct> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
    return productService.getAllProducts(page, size);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseProduct createProduct(@RequestBody RequestProduct request) {
    return productService.createProduct(request);
  }

  @GetMapping("/{id}")
  public ResponseProduct getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PutMapping("/{id}")
  public ResponseProduct updateProduct(@PathVariable Long id, @RequestBody RequestProduct request) {
    return productService.updateProduct(id, request);
  }

  @DeleteMapping("/{id}")
  public String deleteProduct(@PathVariable Long id) {
    return productService.deleteProduct(id);
  }
}
