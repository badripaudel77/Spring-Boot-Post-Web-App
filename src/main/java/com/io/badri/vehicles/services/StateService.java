package com.io.badri.vehicles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.badri.vehicles.models.State;
import com.io.badri.vehicles.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	//get all states
	public List<State> getStates() {
		return stateRepository.findAll(); 
	}

	//save new state to the database
	public void addState(State state) {
		stateRepository.save(state);
	}
	
	//get state by id
	public Optional<State> getStateById(int id) {
     //System.out.println("state from stateservice  " + stateRepository.findById(id));

		return stateRepository.findById(id);
	}

	public void deleteState(int stateId) {
	     System.out.println("state from stateservice  " + stateRepository.findById(stateId));

		stateRepository.deleteById(stateId);
	}
}
