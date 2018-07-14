package com.parkmobile.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parkmobile.app.entity.Establishment;
import com.parkmobile.app.service.*;

@RestController
public class InfoController {
	
	@Autowired
	private InfoService infoService;

	@RequestMapping(value = "info", method = RequestMethod.GET)
	public Establishment getInfo() {
		
		return infoService.getEstablishment();
	}
}
