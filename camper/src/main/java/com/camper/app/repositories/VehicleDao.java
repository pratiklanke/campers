package com.camper.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camper.app.entities.Vehicle;


@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

}
