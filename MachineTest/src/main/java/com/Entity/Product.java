package com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String productName;

  @Column(nullable = false)
  private String productType;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

 
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getProductName() { return productName; }
  public void setProductName(String productName) { this.productName = productName; }

  public String getProductType() { return productType; }
  public void setProductType(String productType) { this.productType = productType; }

  public Category getCategory() { return category; }
  public void setCategory(Category category) { this.category = category; }
}
