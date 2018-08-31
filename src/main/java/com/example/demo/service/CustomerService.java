package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Transactional
	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Transactional
	public Customer findByCustomerId(int customerId) {
		return customerRepository.findById(customerId).get();
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Transactional
	public void deleteAllCustomer() {
		customerRepository.deleteAll();
	}

	@Transactional
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

	@Transactional
	public Iterable<Customer> saveAllCustomer(List<Customer> customer) {
		return customerRepository.saveAll(customer);
	}
}
