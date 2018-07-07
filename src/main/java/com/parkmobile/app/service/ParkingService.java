package com.parkmobile.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.parkmobile.app.entity.Ticket;
import com.parkmobile.app.model.tokengeneration.TokenGenerationStrategy;
import com.parkmobile.app.repository.TicketRepository;

@Service
public class ParkingService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private TokenGenerationStrategy tokenGenerator;
	
	@Value("${parking.tolerance}")
	private Long toleranceInMinutes;
	
	public Ticket emmitTicket() {
		
		Ticket ticket = tokenGenerator.generateToken(new Ticket());
		this.ticketRepository.save(ticket);
		
		return ticket;
	}
	
	public Ticket getTicket(final String token) {
		
		return this.ticketRepository.findByToken(token);
	}

	private boolean canLeave(final Ticket ticket) {
		
		return (!ticket.isExpired() && ticket.isPaid());
	}
	
	public Long getToleranceInMinutes() {
		return this.toleranceInMinutes;
	}
	
	public void openBarrier(final Ticket ticket) {
		
		if (!canLeave(ticket)) {
			System.out.println("Ticket not allowed to leave...");
			return;
		}
		
		System.out.println("Opening barrier...");
	}
}
