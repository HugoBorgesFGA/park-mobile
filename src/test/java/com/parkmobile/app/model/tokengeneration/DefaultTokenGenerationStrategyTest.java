package com.parkmobile.app.model.tokengeneration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.parkmobile.app.entity.Ticket;

public class DefaultTokenGenerationStrategyTest {

	@Test
	public void testGenerateToken() {
		
		DefaultTokenGenerationStrategy tokenGenerator = new DefaultTokenGenerationStrategy();
		
		Ticket ticket = tokenGenerator.generateToken(new Ticket());
		System.out.println("Recently generated token = " + ticket.getToken());
	}

}
