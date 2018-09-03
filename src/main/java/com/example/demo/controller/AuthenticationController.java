package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.AuthenticationService;

@RestController
@RequestMapping("/booking")
public class AuthenticationController {

	private AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@PostMapping("/login")
	public String loginAuthentication(@RequestBody Customer customer) {
		return authenticationService.authenticateLogin(customer);
	}

	@PostMapping("/logout")
	public void logoutAuthentication(@RequestHeader(value = "Authentication-Token") String token) {
		authenticationService.authenticateLogout(token);
	}
}
