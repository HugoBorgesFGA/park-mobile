package com.parkmobile.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String token;
	
	private LocalDateTime timeEntry;
	private LocalDateTime timePayment;
	private LocalDateTime timeTolerance;
	private LocalDateTime timeLeave;
	
	private boolean paid;
	private double price;
	
	public Ticket() {
		
		this.timeEntry = LocalDateTime.now();
		this.paid = false;
		this.price = 0;
	}
	
	public boolean isExpired() {
		
		return LocalDateTime.now().isAfter(timeTolerance);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getTimeEntry() {
		return timeEntry;
	}

	public void setTimeEntry(LocalDateTime timeEntry) {
		this.timeEntry = timeEntry;
	}

	public LocalDateTime getTimePayment() {
		return timePayment;
	}

	public void setTimePayment(LocalDateTime timePayment) {
		this.timePayment = timePayment;
	}

	public LocalDateTime getTimeTolerance() {
		return timeTolerance;
	}

	public void setTimeTolerance(LocalDateTime timeTolerance) {
		this.timeTolerance = timeTolerance;
	}

	public LocalDateTime getTimeLeave() {
		return timeLeave;
	}

	public void setTimeLeave(LocalDateTime timeLeave) {
		this.timeLeave = timeLeave;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
