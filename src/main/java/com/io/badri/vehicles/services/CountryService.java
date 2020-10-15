package com.io.badri.vehicles.services;

import java.util.List;
import java.util.Optional;

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
	
	//get country by id
	public Optional<Country> getCountryById(int id) {
     //System.out.println("country from countryservice  " + countryRepository.findById(id));

		return countryRepository.findById(id);
	}

	public void deleteCountry(int countryId) {
	     System.out.println("country from countryservice  " + countryRepository.findById(countryId));

		countryRepository.deleteById(countryId);
	}
}
