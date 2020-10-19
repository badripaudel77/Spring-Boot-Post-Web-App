package com.io.badri.vehicles.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.io.badri.vehicles.models.Country;
import com.io.badri.vehicles.models.Location;
import com.io.badri.vehicles.models.State;
import com.io.badri.vehicles.services.CountryService;
import com.io.badri.vehicles.services.LocationService;
import com.io.badri.vehicles.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/admin/locations")
	public String getLocations(Model model) {
		List<Location> locationList = locationService.getLocations();

		model.addAttribute("locations", locationList);
		return "Location";
	}

	@GetMapping("/admin/locations/showFormForAdd")
	public String showFormForAdd(Model model) {

		List<Country> countryList = countryService.getCountries();
		List<State> stateList = stateService.getStates();

		model.addAttribute("countries", countryList);
		model.addAttribute("states", stateList);

		Location location = new Location();
		model.addAttribute("location", location);

		return "forms/LocationForm";
	}

	@PostMapping("/admin/locations/addNew")
	// location is in th:object =
	public String addLocation(@ModelAttribute("location") Location location, Model model) {
		locationService.addLocation(location);
		// redirect to the list and prevent duplicate submission.
		return "redirect:/admin/locations";
	}

	@GetMapping("/admin/locations/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("locationId") int locationId, Model model) {
		// get the location for that location id
		// System.out.println("update" + locationId);
		Optional<Location> location = locationService.getLocationById(locationId);

		// set location as model to pre-populate the form
		model.addAttribute("location", location);

		// has to populate country select drop down.
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());


		// send to form
		return "forms/LocationForm";
	}

	@GetMapping("/admin/locations/deleteLocation")
	public String deleteLocation(@RequestParam("locationId") int locationId, Model model) {
		System.out.println("delete" + locationId);
		Optional<Location> location = locationService.getLocationById(locationId);

		if (location != null) {
			locationService.deleteLocation(locationId);
		}
		return "redirect:/admin/locations";
	}
}
