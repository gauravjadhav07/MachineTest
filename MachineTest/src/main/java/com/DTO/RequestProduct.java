package com.DTO;

public class RequestProduct {
  private String productName;
  private String productType;
  private String categoryName;

  public String getProductName() { return productName; }
  public void setProductName(String productName) { this.productName = productName; }

  public String getProductType() { return productType; }
  public void setProductType(String productType) { this.productType = productType; }

  public String getCategoryName() { return categoryName; }
  public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
