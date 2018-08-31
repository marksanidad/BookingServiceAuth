package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping
	public List<TravelPackage> findAllTravelPackage() {
		return (List<TravelPackage>) travelPackageService.findAllTravelPackage();
	}

	@PostMapping
	public TravelPackage saveAllTravelPackage(@RequestBody TravelPackage travelPackage) {
		return travelPackageService.saveAllTravelPackage(travelPackage);
	}

}
