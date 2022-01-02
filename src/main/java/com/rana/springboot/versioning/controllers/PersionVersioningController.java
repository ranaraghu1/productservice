package com.rana.springboot.versioning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rana.springboot.versioning.bean.PersonV1;
import com.rana.springboot.versioning.bean.PersonV2;

@RestController
public class PersionVersioningController {
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new  PersonV1("Raghu Rana");
	}
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new  PersonV2("Raghu","Rana");
	}

}
