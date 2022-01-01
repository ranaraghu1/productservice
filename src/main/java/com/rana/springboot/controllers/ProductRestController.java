package com.rana.springboot.controllers;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rana.springboot.entites.Product;
import com.rana.springboot.repos.ProductRepository;

@RestController
public class ProductRestController {
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductRestController.class);
	
	@Autowired
	ProductRepository repository;

	@GetMapping(value = "/products/")
	public List<Product> getProducts() {

		return repository.findAll();

	}
	

	@GetMapping(value = "/products/{id}")
	@Transactional(readOnly=true)
	@Cacheable("product-cache")
	public Product getProductById(@PathVariable("id") int id) {
		 LOGGER.info("Finding product by ID:"+id);
		return repository.findById(id).get();

	}

	@PostMapping(value = "/products/")
	public Product createProduct(@Valid @RequestBody Product product) {

	return repository.save(product);

	}

	@PutMapping(value = "/products/")
	public Product updateProduct(@RequestBody Product product) {

		return repository.save(product);

	}

	@DeleteMapping(value = "/products/{id}")
	@CacheEvict("product-cache")
	public void delete(@PathVariable("id") int id) {

		repository.deleteById(id);

	}

	@PatchMapping(value = "/products/")
	public Product partialUpdate(@RequestBody Product product) {

		return repository.save(product);

	}

}
