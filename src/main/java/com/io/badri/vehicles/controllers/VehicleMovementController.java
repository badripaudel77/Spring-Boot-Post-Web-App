package com.io.badri.vehicles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {

	@GetMapping("/vehiclemovements")
	public String getClients() {
		return "VehicleMovement";
	}
}
