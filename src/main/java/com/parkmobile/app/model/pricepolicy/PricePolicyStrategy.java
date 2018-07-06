package com.parkmobile.app.model.pricepolicy;

import com.parkmobile.app.entity.Ticket;

@FunctionalInterface
public interface PricePolicyStrategy {
	
	double calculatePrice(Ticket ticket); 
}
