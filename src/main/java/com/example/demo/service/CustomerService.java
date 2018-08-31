package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer findByCustomerId(int customerId) {
		return customerRepository.findById(customerId).get();
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public void deleteAllCustomer() {
		customerRepository.deleteAll();
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	public Iterable<Customer> saveAllCustomer(List<Customer> customer) {
		return customerRepository.saveAll(customer);
	}
}
