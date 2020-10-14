package com.io.badri.vehicles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.badri.vehicles.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
