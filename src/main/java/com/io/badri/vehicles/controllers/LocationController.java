package com.io.badri.vehicles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {

	@GetMapping("/locations")
	public String getClients() {
		return "Location";
	}
}
