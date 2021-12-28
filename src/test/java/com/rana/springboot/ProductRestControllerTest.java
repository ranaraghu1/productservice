package com.rana.springboot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rana.springboot.entites.Product;
import com.rana.springboot.repos.ProductRepository;
@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ProductRepository repository;
	
@Value("${Product.service-url}")
private String baseUrl;

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

}
