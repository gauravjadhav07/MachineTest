package com.DTO;

public class ResponseProduct {
  private Long id;
  private String productName;
  private String productType;
  private ResponseCategory category;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getProductName() { return productName; }
  public void setProductName(String productName) { this.productName = productName; }

  public String getProductType() { return productType; }
  public void setProductType(String productType) { this.productType = productType; }

  public ResponseCategory getCategory() { return category; }
  public void setCategory(ResponseCategory category) { this.category = category; }
}
