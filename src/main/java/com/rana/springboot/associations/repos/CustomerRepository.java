package com.rana.springboot.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.rana.springboot.associations.entites.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
