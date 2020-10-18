package com.io.badri.vehicles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.badri.vehicles.models.NormalUser;
import com.io.badri.vehicles.models.User;

@Repository
public interface NormalUserRepository extends JpaRepository<NormalUser, Integer>{

	NormalUser findByUsername(String username);
	public NormalUser findByPassword(String password);
}

