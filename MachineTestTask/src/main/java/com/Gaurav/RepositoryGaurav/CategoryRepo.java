package com.Gaurav.RepositoryGaurav;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gaurav.EntityGaurav.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

	boolean existsByCategoryName(String cname);

	Optional<Category> findByCategoryName(String cname);
}
