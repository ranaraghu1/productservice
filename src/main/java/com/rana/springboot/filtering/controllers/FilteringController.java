package com.rana.springboot.filtering.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rana.springboot.filtering.bean.User;

@RestController
public class FilteringController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FilteringController.class);

	@GetMapping("/filtering/")
	public MappingJacksonValue filtering() {
		LOGGER.info("FilteringController");
		User user = new User(234, "Raja", "54677587587");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("userFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		return mapping;
	}

}
