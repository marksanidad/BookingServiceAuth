package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Image;
import com.example.demo.model.Service;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.TravelPackageRepository;

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

	@Transactional
	public List<TravelPackage> findAllTravelPackage() {
		return (List<TravelPackage>) travelPackageRepository.findAll();
	}

	@Transactional
	public TravelPackage saveAllTravelPackage(TravelPackage travelPackage) {
		travelPackage = travelPackageRepository.save(travelPackage);
		for (Service allService : travelPackage.getAvailableServiceList()) {
			allService.setTravelPackage(travelPackage);
			saveService(allService);
		}
		for (Image allImageService : travelPackage.getImages()) {
			allImageService.setTravelPackage(travelPackage);
			saveAllImage(allImageService);
		}
		return travelPackage;
	}

	@Transactional
	public Service findService(int serviceId) {
		return servicesRepository.findById(serviceId).get();
	}

	@Transactional
	public Service saveService(Service service) {
		service = servicesRepository.save(service);
		for (Image allImage : service.getImages()) {
			allImage.setService(service);
			saveAllImage(allImage);
		}

		return service;
	}

	@Transactional
	public Image saveAllImage(Image image) {
		return imageRepository.save(image);
	}

	@Transactional
	public void deleteAllTravelPackage() {
		deleteAllService();
		travelPackageRepository.deleteAll();
	}

	@Transactional
	public void deleteAllService() {
		imageRepository.deleteAll();
		servicesRepository.deleteAll();
	}

	@Transactional
	public TravelPackage findTravelPackageId(int travelPackageId) {
		return travelPackageRepository.findById(travelPackageId).get();
	}

	@Transactional
	public void deleteTravelPackage(int travelPackageId) {
		travelPackageRepository.deleteById(travelPackageId);
	}

	@Transactional
	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {
		return travelPackageRepository.save(travelPackage);
	}

	@Transactional
	public void deleteTravelPackageService(List<Service> services) {
		servicesRepository.deleteAll(services);
	}

	@Transactional
	public List<Service> findByTravelPackage(TravelPackage travelPackage) {
		return servicesRepository.findByTravelPackage(travelPackage);
	}
}
