package com.camper.app.dtos;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDto {

	private Integer vehicleId;
	
	private MultipartFile file;

	private String company;

	private String modelName;

	private String registrationNumber;

	private double rent;

	private double deposite;

	private String description;

}
