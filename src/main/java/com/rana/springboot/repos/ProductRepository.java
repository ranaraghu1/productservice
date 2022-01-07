package com.rana.springboot.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.rana.springboot.entites.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByName(String string);
	
	List<Product> findByPriceGreaterThan(Double string);
	
	

	
}
