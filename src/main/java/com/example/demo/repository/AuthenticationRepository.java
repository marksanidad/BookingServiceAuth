package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Authentication;
import com.example.demo.model.Customer;

public interface AuthenticationRepository extends CrudRepository<Authentication, Integer> {

	public Authentication findByToken(String token);

	public List<Authentication> findByCustomer(Customer customer);

}
