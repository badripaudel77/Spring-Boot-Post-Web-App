package com.io.badri.vehicles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	/*
	 * mapping for home admin page /index
	 */
	@GetMapping("/admin")
	public String showHomePage() {
		return "index"; // redirects to index.html from /template/index.html
	}
	
	/*
	@GetMapping("/admin/index")
	public String homePage() {
		return "index"; // redirects to index.html from /template/index.html
	}
	*/
	
	@GetMapping("/admin/register")
	public String registerPage() {
		return "forms/register"; // redirects to index.html from /template/index.html
	}
	
	@GetMapping("/admin/login")
	public String loginPage() {
		return "forms/login"; // redirects to index.html from /template/index.html
	}
	
	@GetMapping("/admin/logout")
	public String logout() {
		return "forms/login"; // redirects to index.html from /template/index.html
	}
}
