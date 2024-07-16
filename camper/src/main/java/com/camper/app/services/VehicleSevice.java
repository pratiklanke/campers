package com.camper.app.services;

import java.io.IOException;
import java.util.List;

import com.camper.app.dtos.VehicleDto;

public interface VehicleSevice {
	List<VehicleDto> getAllVehicles();
	
	VehicleDto addNewVehicle(VehicleDto vDto) throws IOException;
}
