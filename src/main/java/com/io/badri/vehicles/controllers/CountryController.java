package com.io.badri.vehicles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("countries/addNew")
	public String addCountry(Country country, Model model) {
		countryService.addCountry(country);
        
		return "redirect:/countries";
	}
}
