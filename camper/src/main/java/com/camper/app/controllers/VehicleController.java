package com.camper.app.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camper.app.dtos.VehicleDto;
import com.camper.app.services.VehicleSevice;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:5173/")
public class VehicleController {

	@Autowired
	private VehicleSevice vehiServ;

	@GetMapping("/all/vehicles")
	public ResponseEntity<?> getAllVehicleDtls() {
		return ResponseEntity.ok(vehiServ.getAllVehicles());
	}

	@PostMapping("/owner/vehicle/add")
	public ResponseEntity<?> addNewVehiDtls(@RequestBody VehicleDto dto) throws IOException {
		return ResponseEntity.status(HttpStatus.CREATED).body(vehiServ.addNewVehicle(dto));
	}

}
