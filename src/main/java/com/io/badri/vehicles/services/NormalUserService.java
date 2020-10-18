package com.io.badri.vehicles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.io.badri.vehicles.models.NormalUser;
import com.io.badri.vehicles.repositories.NormalUserRepository;

@Service
public class NormalUserService {
	
	@Autowired
	private NormalUserRepository normalUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//save new normalUser to the database
	public void addNormalUser(NormalUser normalUser) {
		//before saving encode password and save it
		String plainPassword = normalUser.getPassword();
		normalUser.setPassword(bCryptPasswordEncoder.encode(plainPassword));
		
		normalUserRepository.save(normalUser);
	}
	
	public boolean getLoggedinUser(NormalUser user) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

		NormalUser userWithUsername = normalUserRepository.findByUsername(username);//as username is unique
		
		String hashedPassword = "";
		
		 if(userWithUsername !=null) {
		    hashedPassword = userWithUsername.getPassword();
		   System.out.println("------------" + userWithUsername + " _------------- " + hashedPassword);
		 }
		 
			 
		boolean isPasswordMatched = bcryptEncoder.matches(password, hashedPassword);
		
		if ((normalUserRepository.findByUsername(username) !=null && isPasswordMatched)) {
			return true;
		}
	   return false;
	}
	
	//get normalUser by id
	public Optional<NormalUser> getNormalUserById(int id) {
     //System.out.println("normalUser from normalUserservice  " + normalUserRepository.findById(id));

		return normalUserRepository.findById(id);
	}

	public void deleteNormalUser(int normalUserId) {
	     System.out.println("normalUser from normalUserservice  " + normalUserRepository.findById(normalUserId));

		normalUserRepository.deleteById(normalUserId);
	}
}
