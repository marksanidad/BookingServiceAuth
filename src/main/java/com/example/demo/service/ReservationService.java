package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

public class ReservationService {

	ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	public Iterable<Reservation> findAllReservation() {
		return reservationRepository.findAll();
	}
//
//	public Reservation saveAllReservation(Reservation reservation) {
//		reservation = reservationRepository.save(reservation);
//
//	}

}
