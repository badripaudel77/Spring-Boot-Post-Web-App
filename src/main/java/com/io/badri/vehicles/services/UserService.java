package com.io.badri.vehicles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.badri.vehicles.models.User;
import com.io.badri.vehicles.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	//save new user to the database
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	//get user by id
	public Optional<User> getUserById(int id) {
     //System.out.println("user from userservice  " + userRepository.findById(id));

		return userRepository.findById(id);
	}

	public void deleteUser(int userId) {
	     System.out.println("user from userservice  " + userRepository.findById(userId));

		userRepository.deleteById(userId);
	}
}
