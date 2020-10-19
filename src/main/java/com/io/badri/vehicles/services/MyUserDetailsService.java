package com.io.badri.vehicles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.io.badri.vehicles.models.User;
import com.io.badri.vehicles.models.UserPrincipal;
import com.io.badri.vehicles.repositories.UserRepository;

//for user login spring security
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Sorry, that user doesn't exist.");
		}
		//return user principal. Wraps a user
		return new UserPrincipal(user);
	}
}
