package com.rana.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rana.springboot.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
