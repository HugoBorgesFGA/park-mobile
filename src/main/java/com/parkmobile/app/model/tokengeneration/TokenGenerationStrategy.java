package com.parkmobile.app.model.tokengeneration;

import com.parkmobile.app.entity.Ticket;

@FunctionalInterface
public interface TokenGenerationStrategy {

	Ticket generateToken(Ticket ticket);
}
