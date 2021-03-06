package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	public Customer findByUserNameAndPassword(String userName, String password);

	public Boolean existsByUserNameAndPassword(String userName, String password);

}
