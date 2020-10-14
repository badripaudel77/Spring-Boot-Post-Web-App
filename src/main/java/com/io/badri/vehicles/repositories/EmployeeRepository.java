package com.io.badri.vehicles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.badri.vehicles.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
