package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	// Get all Customers
	@GetMapping
	public List<Customer> getAllCustomers(@RequestHeader(value = "Authentication-Token") String token) {
		return (List<Customer>) customerService.findAllCustomers();
	}

	// Post a Customer
	@PostMapping
	public Customer saveCustomer(@RequestHeader(value = "Authentication-Token") String token,
			@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

//	@PutMapping
//	public List<Customer> putCustomer(@RequestBody Customer customer) {
//		return (List<Customer>) customerService.saveAllCustomer(customer);
//	}

	// Delete all Customers
	@DeleteMapping
	public void deleteAllCustomer() {
		customerService.deleteAllCustomer();
	}

	// Get a specific Customer using CustomerID
	@GetMapping("/{customerId}")
	public Customer getCustomer(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("customerId") int customerId) {
		return customerService.findByCustomerId(customerId);
	}

	// Post a Customer in a specific CustomerID
	@PostMapping("/{customerId}")
	public Customer saveCustomerID(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		return customerService.saveCustomer(customer);
	}

	// Update a Customer in a specific CustomerID
	@PutMapping("/{customerId}")
	public Customer putCustomerID(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		return customerService.saveCustomer(customer);
	}

	// Delete a Customer in a specific CustomerID
	@DeleteMapping("/{customerId}")
	public void deleteCustomerID(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerService.findByCustomerId(customerId));
	}

}
