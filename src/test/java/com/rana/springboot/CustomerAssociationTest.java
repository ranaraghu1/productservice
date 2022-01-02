package com.rana.springboot;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rana.springboot.associations.entites.Customer;
import com.rana.springboot.associations.entites.PhoneNumber;
import com.rana.springboot.associations.repos.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAssociationTest {
	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	public void testCreateCustomer() {
		Customer customer=new Customer();
		customer.setName("Sonu");
		
		HashSet<PhoneNumber> numbers=new HashSet<PhoneNumber>();
		
		PhoneNumber ph1=new PhoneNumber();
		ph1.setNumber("454545545454");
		ph1.setType("Cell");
		ph1.setCustomer(customer);
		numbers.add(ph1);
		
		PhoneNumber ph2=new PhoneNumber();
		ph2.setNumber("123909090");
		ph2.setType("Mobile");
		ph2.setCustomer(customer);
		numbers.add(ph2);
		
		customer.setNumbers(numbers);
		customerRepo.save(customer);
		
		
	}

}
 