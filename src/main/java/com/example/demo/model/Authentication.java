package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Authentication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authenticationId;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private String token;

	public int getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(int authenticationId) {
		this.authenticationId = authenticationId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
