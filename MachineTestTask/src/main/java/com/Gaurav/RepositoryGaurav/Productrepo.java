package com.Gaurav.RepositoryGaurav;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gaurav.EntityGaurav.Product;

@Repository
public interface Productrepo extends JpaRepository<Product, Long> {

	
	
}
