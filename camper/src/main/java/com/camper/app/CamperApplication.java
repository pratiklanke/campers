package com.camper.app;

import java.time.LocalDate;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CamperApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamperApplication.class, args);
	}
	
	@Bean 
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());
		modelMapper.addConverter(new StringToDateConverter());
		return modelMapper;
	}
	public class StringToDateConverter extends AbstractConverter<String,LocalDate> {
	    @Override
	    protected LocalDate convert(String source) {
	        return LocalDate.parse(source);
	    }
	}

}
