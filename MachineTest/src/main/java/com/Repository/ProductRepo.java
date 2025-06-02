package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
