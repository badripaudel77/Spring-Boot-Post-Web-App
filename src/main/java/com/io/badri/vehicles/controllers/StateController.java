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

import com.io.badri.vehicles.models.State;
import com.io.badri.vehicles.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/states")
	public String getStates(Model model) {
		List<State> stateList = stateService.getStates();
		
		model.addAttribute("states", stateList);
		return "State";
	}
	@GetMapping("/states/showFormForAdd") 
	public String showFormForAdd(Model model){
		State state = new State();
		
	    model.addAttribute("state", state);
	    return "forms/StateForm";
	}
	
	@PostMapping("/states/addNew")
	//state is in th:object = 
	public String addState(@ModelAttribute("state") State state) {
		stateService.addState(state);
        
		//redirect to the list and prevent duplicate submission.
		return "redirect:/states";
	}
	
	@GetMapping("/states/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("stateId") int stateId, Model model) {
		   // get the state for that state id
            // System.out.println("update" + stateId);
		   Optional<State> state = stateService.getStateById(stateId);		    
		   
		   //set state as model to pre-populate the form
			model.addAttribute("state", state);
		
		   //send to form
		   return "forms/StateForm";
	}
	
	@GetMapping("/states/deleteState")
	public String deleteState(@RequestParam("stateId") int stateId, Model model) {
		   System.out.println("delete" + stateId);
		   Optional<State> state = stateService.getStateById(stateId);		    
		   
		   if(state !=null) {
			   stateService.deleteState(stateId);
		   }
		return "redirect:/states";
	}
}

