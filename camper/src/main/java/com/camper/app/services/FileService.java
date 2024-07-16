package com.camper.app.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
	
	MultipartFile uploadImage(String path, MultipartFile file) throws IOException;

}
