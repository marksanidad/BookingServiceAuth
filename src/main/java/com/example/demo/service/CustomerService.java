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

	@Transactional(readOnly = true)
	public List<Customer> findAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Transactional(readOnly = true)
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
	public List<Customer> saveAllCustomer(List<Customer> customer) {
		return (List<Customer>) customerRepository.saveAll(customer);
	}

}
