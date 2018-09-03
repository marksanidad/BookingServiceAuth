package com.example.demo.controller;

import com.example.demo.service.ReservationService;

public class ReservationController {

	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

}
