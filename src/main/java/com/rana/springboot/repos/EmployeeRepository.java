package com.rana.springboot.repos;

import org.springframework.data.repository.CrudRepository;

import com.rana.springboot.entites.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
