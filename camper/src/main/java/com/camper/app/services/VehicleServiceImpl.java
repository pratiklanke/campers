package com.camper.app.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.camper.app.dtos.VehicleDto;
import com.camper.app.entities.Vehicle;
import com.camper.app.repositories.VehicleDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleSevice {

	@Autowired
	private VehicleDao vehicleDao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private FileService fileServ;

	@Value("${project.image}")
	private String path;

	@Override
	public List<VehicleDto> getAllVehicles() {

		List<Vehicle> vehiList = vehicleDao.findAll();
		return vehiList.stream().map(v -> mapper.map(v, VehicleDto.class)).collect(Collectors.toList());

	}

	@Override
	public VehicleDto addNewVehicle(VehicleDto vDto) throws IOException {

		MultipartFile uploadFile = fileServ.uploadImage(path, vDto.getFile());

		Vehicle v = new Vehicle();
		v.setCompany(vDto.getCompany());
		v.setDeposite(vDto.getDeposite());
		v.setDescription(vDto.getDescription());
		v.setModelName(vDto.getModelName());
		v.setRegistrationNumber(vDto.getRegistrationNumber());
		v.setRent(vDto.getRent());
		
		Vehicle mappedVehi = mapper.map(v, Vehicle.class);
		Vehicle savedVehi = vehicleDao.save(mappedVehi);
		
		VehicleDto vehiDto = new VehicleDto();
		
		vehiDto.setCompany(savedVehi.getCompany());
		vehiDto.setDeposite(savedVehi.getDeposite());
		vehiDto.setDescription(savedVehi.getDescription());
		vehiDto.setModelName(savedVehi.getModelName());
		vehiDto.setRegistrationNumber(savedVehi.getRegistrationNumber());
		vehiDto.setRent(savedVehi.getRent());
		vehiDto.setFile(uploadFile);
		
		VehicleDto mappedVehiDto = mapper.map(vehiDto, VehicleDto.class);
		
		return mappedVehiDto;
		
	}

}
