package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.AuthenticationRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.util.TokenCreator;

public class AuthenticationService {

	private AuthenticationRepository authenticationRepository;
	private CustomerRepository customerRepository;

	public AuthenticationService(AuthenticationRepository authenticationRepository,
			CustomerRepository customerRepository) {
		super();
		this.authenticationRepository = authenticationRepository;
		this.customerRepository = customerRepository;
	}

	public String authenticateLogin(Customer customer) {
		String newToken = "";
		if (customerRepository.findByUserName(customer.getUserName()) != null) {
			TokenCreator tokenCreator = new TokenCreator();
			newToken = tokenCreator.encode(customer);
		} else {
			throw new RuntimeException("Invalid Input");
		}
		return newToken;
	}
}
