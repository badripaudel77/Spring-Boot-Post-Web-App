package com.io.badri.vehicles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.badri.vehicles.models.Location;
import com.io.badri.vehicles.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	//get all locations
	public List<Location> getLocations() {
		return locationRepository.findAll(); 
	}

	//save new location to the database
	public void addLocation(Location location) {
		locationRepository.save(location);
	}
	
	//get location by id
	public Optional<Location> getLocationById(int id) {
     //System.out.println("location from locationservice  " + locationRepository.findById(id));

		return locationRepository.findById(id);
	}

	public void deleteLocation(int locationId) {
	     System.out.println("location from locationservice  " + locationRepository.findById(locationId));

		locationRepository.deleteById(locationId);
	}
}
