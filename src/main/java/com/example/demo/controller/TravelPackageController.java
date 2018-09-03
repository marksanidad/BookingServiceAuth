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

import com.example.demo.model.Service;
import com.example.demo.model.TravelPackage;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {

	private TravelPackageService travelPackageService;

	public TravelPackageController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}

	// Get All TravelPackages
	@GetMapping
	public List<TravelPackage> findAllTravelPackage(@RequestHeader(value = "Authentication-Token") String token) {
		return (List<TravelPackage>) travelPackageService.findAllTravelPackage();
	}

	// Post a TravelPackage
	@PostMapping
	public TravelPackage saveAllTravelPackage(@RequestHeader(value = "Authentication-Token") String token,
			@RequestBody TravelPackage travelPackage) {
		return travelPackageService.saveAllTravelPackage(travelPackage);
	}

	// Delete All TravelPackages
	@DeleteMapping
	public void deleteAllTravelPackage(@RequestHeader(value = "Authentication-Token") String token) {
		travelPackageService.deleteAllTravelPackage();
	}

	// Get a specific TravelPackage using TravelPackageID
	@GetMapping("/{travelPackageId}")
	public TravelPackage findTravelPackage(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findTravelPackageId(travelPackageId);
	}

	// Update a specific TravelPackage using TravelPackageID
	@PutMapping("/{travelPackageId}")
	public TravelPackage updateTravelPackage(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("travelPackageId") int travelPackageId, @RequestBody TravelPackage travelPackage) {
		travelPackage.setTravelPackageId(travelPackageId);
		return travelPackageService.saveTravelPackage(travelPackage);
	}

	// Delete a specific TravelPackage using TravelPackageID
	@DeleteMapping("/{travelPackageId}")
	public void deleteTravelPackage(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("travelPackageId") int travelPackageId) {
		travelPackageService.deleteTravelPackage(travelPackageId);
	}

	// Get all TravelPackageServices by using TravelPackageID
	@GetMapping("/{travelPackageId}/services")
	public List<Service> findAllTravelPackageService(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findTravelPackageId(travelPackageId).getAvailableServiceList();
	}

	// Post a TravelPackageService in a specific TravelPackageID
	@PostMapping("/{travelPackageId}/services")
	public Service saveAllTravelPackageService(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("travelPackageId") int travelPackageId, @RequestBody Service services) {
		services.setTravelPackage(travelPackageService.findTravelPackageId(travelPackageId));
		return travelPackageService.saveService(services);
	}

//	@PutMapping("/{travelPackageId}/services")
//	public Services updateServices(@PathVariable("travelPackageId") int travelPackageId,
//			@RequestBody Services services) {
//		return travelPackageService.saveService(services);
//
//	}

	// Delete a TravelPackage Service in a specific TravelPackageID
	@DeleteMapping("/{travelPackageId}/services")
	public void deleteAllTravelPackageService(@RequestHeader(value = "Authentication-Token") String token,
			@PathVariable("travelPackageId") int travelPackageId) {
		TravelPackage travel = travelPackageService.findTravelPackageId(travelPackageId);
		List<Service> services = travelPackageService.findByTravelPackage(travel);
		travelPackageService.deleteTravelPackageService(services);
	}

}
