package com.io.badri.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.io.badri.vehicles.services.PostService;
import com.io.badri.vehicles.services.UserService;

@Controller
public class ApplicationController {

	 /*
	  * mapping for home admin page /index route.
	  */
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private PostService postService;
	
	public int getUsersCount() {
		return userService.countUsers();
	}
	
	private int getPostCounts() {
		return postService.countPosts();
	}
	
	@GetMapping("/")
	public String redirectToPublicPage(Model model) {
		return "redirect:/posts";
	}
	
	@GetMapping("/admin")
	public String showHomePage(Model model) {
	
		model.addAttribute("usersCount", getUsersCount());
		model.addAttribute("postsCount", getPostCounts());

		return "index"; // redirects to index.html from /template/index.html
	}
	
	
	@GetMapping("/index")
	public String homePage(Model model) {
		
		model.addAttribute("usersCount", getUsersCount());
		model.addAttribute("postsCount", getPostCounts());
		
		return "index"; // redirects to index.html from /template/index.html
	}
		
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
