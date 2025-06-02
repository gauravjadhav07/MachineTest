package com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
  Optional<Category> findByCategoryNameIgnoreCase(String categoryName);
}
