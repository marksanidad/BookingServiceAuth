package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.model.Services;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.TravelPackageRepository;

@Service
public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	private ServiceRepository servicesRepository;
	private ImageRepository imageRepository;

	public TravelPackageService(ServiceRepository serviceRepository, ImageRepository imageRepository,
			TravelPackageRepository travelPackageRepository) {
		super();
		this.servicesRepository = serviceRepository;
		this.imageRepository = imageRepository;
		this.travelPackageRepository = travelPackageRepository;
	}

	public Iterable<TravelPackage> findAllTravelPackage() {
		return travelPackageRepository.findAll();
	}

	public TravelPackage saveAllTravelPackage(TravelPackage travelPackage) {
		travelPackage = travelPackageRepository.save(travelPackage);
		for (Services allService : travelPackage.getAvailableServiceList()) {
			allService.setTravelPackage(travelPackage);
			saveService(allService);
		}
		for (Image allImageService : travelPackage.getImages()) {
			allImageService.setTravelPackage(travelPackage);
			saveAllImage(allImageService);
		}
		return travelPackage;
	}

	public Services findAllService(int serviceId) {
		return servicesRepository.findById(serviceId).get();
	}

	public Services saveService(Services service) {
		service = servicesRepository.save(service);
		for (Image allImage : service.getImages()) {
			allImage.setService(service);
			saveAllImage(allImage);
		}

		return service;
	}

	public Image saveAllImage(Image image) {
		return imageRepository.save(image);
	}

	public void deleteAllService() {
		imageRepository.deleteAll();
		servicesRepository.deleteAll();
	}

}
