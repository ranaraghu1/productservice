package com.rana.springboot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.rana.springboot.controllers.ProductRestController;
import com.rana.springboot.entites.Product;
import com.rana.springboot.repos.ProductRepository;
@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductRestControllerTest {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductRestControllerTest.class);

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ProductRepository repository;
	
@Value("${Product.service-url}")
private String baseUrl;

@Value("${service-url}")
private String serviceUrl;

	@Test
	public void testFindAll() throws Exception {
		Product product =new Product();
		product.setId(1);
		product.setName("Mac Book");
		product.setDescription("Mac Book 7");
		product.setPrice(4000);
		List<Product> products=Arrays.asList(product);
       when(repository.findAll()).thenReturn(products);
       mockMvc.perform(get(baseUrl).contextPath("/productapi")).andExpect(status().isOk());
       
     
		
	}
	
	@Test
	public void testGetProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Product newProduct=restTemplate.getForObject(serviceUrl+"1",Product.class);
		assertNotNull(newProduct);
	
	}
	
	//finder-Method
	@Test
	public void testFindByName() {
		List<Product> products=repository.findByName("Nokia");
		products.forEach(p->System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products=repository.findByPriceGreaterThan(1000d);
		products.forEach(p->System.out.println("Price: "+p.getPrice()));
	}
	
	
	@Test
	public void testFindAllProducts() {
		 LOGGER.info("testFindAllProducts");
		List<Product> products=repository.findAll();
		products.forEach(p->System.out.println(p.getPrice()));
		
		
	}

}
