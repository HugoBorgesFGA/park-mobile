package com.parkmobile.app.model.tokengeneration;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.parkmobile.app.entity.Establishment;
import com.parkmobile.app.entity.Ticket;

@Component
@Qualifier("defaultTokenGeneration")
public class DefaultTokenGenerationStrategy implements TokenGenerationStrategy {
	
	@Autowired
	private Establishment establishment;

	@Override
	public Ticket generateToken(Ticket ticket) {
		
		final Timestamp timestamp = Timestamp.valueOf(ticket.getTimeEntry());
		final StringBuilder token = new StringBuilder()
										.append(String.format("%04d", establishment.getId())) // Four first numeric digits
										.append(Integer.toString(timestamp.getNanos(), 36));  // Random string value from timestamp
										
		ticket.setToken(token.toString());
		
		return ticket;
	}
}
