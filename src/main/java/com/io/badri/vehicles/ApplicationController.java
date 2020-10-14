package com.io.badri.vehicles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	/*
	 * mapping for home admin page /index
	 */

	@GetMapping("/index")
	public String homePage() {
		return "index"; // redirects to index.html from /template/index.html
	}
}
