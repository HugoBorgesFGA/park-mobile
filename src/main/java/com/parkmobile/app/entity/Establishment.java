package com.parkmobile.app.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Establishment{
	
	@Value("${parking.info.name}")
	private String name;
	
	@Value("${parking.info.logo}")
	private String logo;
	
	@Value("${parking.info.coordinates}")
	private String coordinates;
	
	public Establishment() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public Establishment setName(String name) {
		
		this.name = name;
		return this;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public Establishment setLogo(String logo) {
		
		this.logo = logo;
		return this;
	}
	
	public String getCoordinates() {
		return coordinates;
	}
	
	public Establishment setCoordinates(String coordinates) {
		
		this.coordinates = coordinates;
		return this;
	}
}
