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
	
	public List<Country> getCountries() {
		return countryRepository.findAll(); 
	}

}
