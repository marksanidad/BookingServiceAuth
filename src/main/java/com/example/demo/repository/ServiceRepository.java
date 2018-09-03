package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Service;
import com.example.demo.model.TravelPackage;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer> {

	public List<Service> findByTravelPackage(TravelPackage travelPackage);
}
