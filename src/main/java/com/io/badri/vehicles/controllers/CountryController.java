package com.io.badri.vehicles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.io.badri.vehicles.models.Country;
import com.io.badri.vehicles.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countries")
	public String getCountries(Model model) {
		List<Country> countryList = countryService.getCountries();
		
		model.addAttribute("countries", countryList);
		return "Country";
	}
}
