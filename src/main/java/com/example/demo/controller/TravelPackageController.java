package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Services;
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

	@DeleteMapping
	public void deleteAllTravelPackage() {
		travelPackageService.deleteAllTravelPackage();
	}

	@GetMapping("/{travelPackageId}")
	public TravelPackage findTravelPackage(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findTravelPackage(travelPackageId);
	}

	@PutMapping("/{travelPackageId}")
	public TravelPackage updateTravelPackage(@PathVariable("travelPackageId") int travelPackageId,
			@RequestBody TravelPackage travelPackage) {
		travelPackage.setTravelPackageId(travelPackageId);
		return travelPackageService.saveTravelPackage(travelPackage);
	}

	@DeleteMapping("/{travelPackageId}")
	public void deleteTravelPackage(@PathVariable("travelPackageId") int travelPackageId) {
		travelPackageService.deleteTravelPackage(travelPackageId);
	}

	@GetMapping("/{travelPackageId}/services")
	public List<Services> findAllTravelPackageService(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findTravelPackage(travelPackageId).getAvailableServiceList();
	}

	@PostMapping("/{travelPackageId}/services")
	public Services saveAllTravelPackageService(@PathVariable("travelPackageId") int travelPackageId,
			@RequestBody Services services) {
		services.setTravelPackage(travelPackageService.findTravelPackage(travelPackageId));
		return travelPackageService.saveService(services);
	}

//	@PutMapping("/{travelPackageId}/services")
//	public Services updateServices(@PathVariable("travelPackageId") int travelPackageId,
//			@RequestBody Services services) {
//		return travelPackageService.saveService(services);
//
//	}

	@DeleteMapping("/{travelPackageId}/services")
	public void deleteAllTravelPackageService(@PathVariable("travelPackageId") int travelPackageId) {
		travelPackageService.deleteTravelPackageService(findAllTravelPackageService(travelPackageId));
	}

}
