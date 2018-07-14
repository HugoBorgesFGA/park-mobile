package com.parkmobile.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkmobile.app.entity.Establishment;

@Service
public class InfoService {
	
	@Autowired
	private Establishment establishment;
	
	public Establishment getEstablishment() {
		return establishment;
	}
}
