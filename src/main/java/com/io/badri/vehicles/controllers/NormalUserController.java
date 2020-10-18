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

import com.io.badri.vehicles.models.NormalUser;
import com.io.badri.vehicles.services.NormalUserService;

@Controller
public class NormalUserController {
	
	@Autowired
	private NormalUserService normalUserService;	
	
	@GetMapping("/normalusers/register")
	public String showNormaUserSignupForm() {
		return "forms/NormalUserRegister";
	}
	
	@GetMapping("/normalusers/login")
	public String showNormaUserLoginForm() {
		return "forms/NormalUserLogin";
	}
	
	@PostMapping("/normalusers/register")
	//normalUser is in th:object = 
	public RedirectView addNormalUser(@ModelAttribute("normalUser") NormalUser normalUser, RedirectAttributes redirectAtr) {
		normalUserService.addNormalUser(normalUser);
        
      // extra to send message 		
		RedirectView rView = new RedirectView("/normalusers/login", true);
		
		redirectAtr.addFlashAttribute("loginMessage", "You are registered successfully");
			
		return rView;
	}
	
	@PostMapping("normalusers/login")
	//normalUser is in th:object = 
	public String loginNormalUser(NormalUser normalUser) {
		System.out.println("hting url ? ");
		boolean user = normalUserService.getLoggedinUser(normalUser);
		System.out.println("user ??" + user);
		if(user) {
			System.out.println(normalUser.getUsername());
			return "redirect:/users";
		}	
		return "/normalusers/login";
	}
	
	@GetMapping("/normalUsers/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("normalUserId") int normalUserId, Model model) {
		   // get the normalUser for that normalUser id
            // System.out.println("update" + normalUserId);
		   Optional<NormalUser> normalUser = normalUserService.getNormalUserById(normalUserId);		    
		   
		   //set normalUser as model to pre-populate the form
			model.addAttribute("normalUser", normalUser);
		
		   //send to form
		   return "forms/login";
	}
	
	@GetMapping("/normalUsers/deleteNormalUser")
	public String deleteNormalUser(@RequestParam("normalUserId") int normalUserId, Model model) {
		   System.out.println("delete" + normalUserId);
		   Optional<NormalUser> normalUser = normalUserService.getNormalUserById(normalUserId);		    
		   
		   if(normalUser !=null) {
			   normalUserService.deleteNormalUser(normalUserId);
		   }
		
		return "redirect:/index";
	}
}
