package com.parkmobile.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parkmobile.app.entity.Ticket;
import com.parkmobile.app.service.ParkingService;

@RestController
public class ParkingController {
	
	@Autowired
	ParkingService parkingService;

	@RequestMapping(value = "ticket/emmit", method = RequestMethod.PUT)
	public Ticket emmitTicket() {
		
		return parkingService.emmitTicket();
	}
	
	@RequestMapping(value = "ticket/{token}", method = RequestMethod.GET)
	public Ticket getTicketInfo(@PathVariable String token) {
		
		return parkingService.getTicket(token);
	}
}
