package com.parkmobile.app.model.pricepolicy;

import org.springframework.stereotype.Component;

import com.parkmobile.app.entity.Ticket;

@Component
public class DefaultPricePolicy implements PricePolicyStrategy {

	@Override
	public double calculatePrice(Ticket ticket) {
		
		return 6;
	}

}
