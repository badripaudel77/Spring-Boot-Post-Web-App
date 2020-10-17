package com.io.badri.vehicles.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.io.badri.vehicles.models.User;
import com.io.badri.vehicles.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;	

	@GetMapping("/users/showFormForAdd") 
	public String showFormForAdd(Model model){
		User user = new User();
		
	    model.addAttribute("user", user);
	    return "forms/login";
	}
	
	@PostMapping("/users/addNew")
	//user is in th:object = 
	public String addUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
        
		//redirect to the list and prevent duplicate submission.
		return "redirect:/index";
	}
	
	@GetMapping("/users/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int userId, Model model) {
		   // get the user for that user id
            // System.out.println("update" + userId);
		   Optional<User> user = userService.getUserById(userId);		    
		   
		   //set user as model to pre-populate the form
			model.addAttribute("user", user);
		
		   //send to form
		   return "forms/login";
	}
	
	@GetMapping("/users/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId, Model model) {
		   System.out.println("delete" + userId);
		   Optional<User> user = userService.getUserById(userId);		    
		   
		   if(user !=null) {
			   userService.deleteUser(userId);
		   }
		
		return "redirect:/index";
	}
}
