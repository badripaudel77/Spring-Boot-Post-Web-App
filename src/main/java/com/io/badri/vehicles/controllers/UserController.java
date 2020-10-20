package com.io.badri.vehicles.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.io.badri.vehicles.models.User;
import com.io.badri.vehicles.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;	
	
	@PostMapping("/admin/register")
	//user is in th:object = 
	public String addUser(@ModelAttribute("user") User user, RedirectAttributes redirectAtr) {
		userService.addUser(user);
        
      // extra to send message 		
      //RedirectView rView = new RedirectView("/admin/login", true);		
	  //redirectAtr.addFlashAttribute("loginMessage", "You are registered successfully");
			
      //return rView;
	
	  return "redirect:/admin";
	}
	
	@GetMapping("/admin/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int userId, Model model) {
		   // get the user for that user id
            // System.out.println("update" + userId);
		   Optional<User> user = userService.getUserById(userId);		    
		   
		   //set user as model to pre-populate the form
			model.addAttribute("user", user);
		
		   //send to form
		   return "forms/login";
	}
	
	@GetMapping("/admin/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId, Model model) {
		   System.out.println("delete" + userId);
		   Optional<User> user = userService.getUserById(userId);		    
		   
		   if(user !=null) {
			   userService.deleteUser(userId);
		   }
		return "redirect:/admin/index";
	}
}
