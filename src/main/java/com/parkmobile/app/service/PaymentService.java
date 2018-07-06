package com.parkmobile.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkmobile.app.entity.Ticket;
import com.parkmobile.app.model.pricepolicy.PricePolicyStrategy;

@Service
public class PaymentService {
	
	@Autowired
	private PricePolicyStrategy pricePolicy;
	
	@Autowired
	private ParkingService parkingService;

	public void pay(Ticket ticket, final double price) {
		
		ticket.setPaid(true);
		ticket.setPrice(price);
		
		Long minutesOfTolerance = parkingService.getToleranceInMinutes();
		
		ticket.setTimePayment(LocalDateTime.now());
		ticket.setTimeTolerance(ticket.getTimePayment().plusMinutes(minutesOfTolerance));
	}
	
	public double calculatePrice(final Ticket ticket) {
		
		return pricePolicy.calculatePrice(ticket);
	}
}
