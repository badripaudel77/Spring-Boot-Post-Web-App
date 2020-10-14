package com.io.badri.vehicles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.badri.vehicles.models.Country;
import com.io.badri.vehicles.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	//get all countries
	public List<Country> getCountries() {
		return countryRepository.findAll(); 
	}

	//save new country to the database
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
}
