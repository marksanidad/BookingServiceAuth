package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Services;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageServicesController {

	private TravelPackageService travelPackageService;

	public TravelPackageServicesController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}

	@GetMapping("{travelPackageId}/services")
	public Services findAllTravelPackageServices(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findAllService(travelPackageId);
	}

	@PostMapping("{travelPackageId}/services")
	public Services saveAllTravelPackageService(@RequestBody Services service) {
		return travelPackageService.saveService(service);
	}

	@DeleteMapping
	public void deleteAllTravelPackages() {
		travelPackageService.deleteAllService();
	}
}
