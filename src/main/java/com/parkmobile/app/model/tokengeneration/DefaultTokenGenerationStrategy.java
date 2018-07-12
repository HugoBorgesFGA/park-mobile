package com.parkmobile.app.model.tokengeneration;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.parkmobile.app.entity.Ticket;

@Component
@Qualifier("defaultTokenGeneration")
public class DefaultTokenGenerationStrategy implements TokenGenerationStrategy {

	@Override
	public Ticket generateToken(Ticket ticket) {
		
		final Timestamp timestamp = Timestamp.valueOf(ticket.getTimeEntry());
		ticket.setToken(Integer.toString(timestamp.getNanos(), 36));
		
		return ticket;
	}
}
