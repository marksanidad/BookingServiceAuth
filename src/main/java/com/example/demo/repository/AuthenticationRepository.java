package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Authentication;

public interface AuthenticationRepository extends CrudRepository<Authentication, Integer> {

	public Authentication findByToken(String token);

	public boolean existsByToken(String token);

}
