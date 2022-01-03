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
	
	
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 param1() {
		return new  PersonV1("Raghu Rana");
	}
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 param2() {
		return new  PersonV2("Raghu","Rana");
	}

	

	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 header1() {
		return new  PersonV1("Raghu Rana");
	}
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 header2() {
		return new  PersonV2("Raghu","Rana");
	}
	
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.add-v1+json")
	public PersonV1 produces1() {
		return new  PersonV1("Raghu Rana");
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.add-v2+json")
	public PersonV2 produces2() {
		return new  PersonV2("Raghu","Rana");
	}
}
