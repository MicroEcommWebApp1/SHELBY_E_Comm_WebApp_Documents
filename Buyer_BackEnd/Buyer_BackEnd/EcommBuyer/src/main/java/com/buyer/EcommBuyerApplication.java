package com.buyer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEncryptableProperties
@OpenAPIDefinition(info = @Info(description = "Buyer Service Documentation"))
public class EcommBuyerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommBuyerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
