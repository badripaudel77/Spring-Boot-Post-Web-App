package com.io.badri.vehicles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleHireController {

	@GetMapping("/vehiclehires")
	public String getClients() {
		return "VehicleHire";
	}
}
