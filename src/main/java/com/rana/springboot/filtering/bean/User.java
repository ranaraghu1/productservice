package com.rana.springboot.filtering.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("userFilter")
public class User {

	private int id;
	private String name;
	private String cardNumber;

	public User(int id, String name, String cardNumber) {
		super();
		this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
