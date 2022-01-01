package com.rana.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rana.springboot.entites.Employee;
import com.rana.springboot.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IDGeneratorTest {
	@Autowired
	EmployeeRepository employeeRepo;
	@Test
	public void testCreateEmployee() {
		Employee employee= new Employee();
		employee.setName("John");
		employeeRepo.save(employee);
		
	}

}
