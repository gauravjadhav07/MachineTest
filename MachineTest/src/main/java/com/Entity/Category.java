package com.Entity;


import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String categoryName;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Product> products;

  
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getCategoryName() { return categoryName; }
  public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

  public List<Product> getProducts() { return products; }
  public void setProducts(List<Product> products) { this.products = products; }
}
