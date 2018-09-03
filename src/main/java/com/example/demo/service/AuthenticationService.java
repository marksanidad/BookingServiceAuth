package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Authentication;
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

	@Transactional
	public String authenticateLogin(Customer customer) {
		String newToken = "";
		Customer newCustomer = customerRepository.findByUserNameAndPassword(customer.getUserName(),
				customer.getPassword());
		if (newCustomer != null) {
			TokenCreator tokenCreator = new TokenCreator();
			Authentication authentication = new Authentication();
			newToken = tokenCreator.encode(customer);
			authentication.setCustomer(newCustomer);
			authentication.setToken(newToken);
			authenticationRepository.save(authentication);
		}

		else {
			throw new RuntimeException("Invalid Input");
		}
		return newToken;
	}

	@Transactional
	public void authenticateLogout(String token) {
		Authentication getToken = authenticationRepository.findByToken(token);
		authenticationRepository.delete(getToken);
	}
}
