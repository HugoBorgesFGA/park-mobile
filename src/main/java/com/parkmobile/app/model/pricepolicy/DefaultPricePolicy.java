package com.parkmobile.app.model.pricepolicy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.parkmobile.app.entity.Ticket;

@Component
public class DefaultPricePolicy implements PricePolicyStrategy {
	
	@Value("${parking.business.tolerance}")
	private Long toleranceInMinutes;

	@Override
	public double calculatePrice(Ticket ticket) {
		
		LocalDateTime tempDateTime = LocalDateTime.from(ticket.getTimeEntry());
		Long elapsedMinutes = tempDateTime.until(LocalDateTime.now(), ChronoUnit.MINUTES);
		
		if (elapsedMinutes < toleranceInMinutes) return 0;
		
		return (elapsedMinutes * 0.06);
	}

}
