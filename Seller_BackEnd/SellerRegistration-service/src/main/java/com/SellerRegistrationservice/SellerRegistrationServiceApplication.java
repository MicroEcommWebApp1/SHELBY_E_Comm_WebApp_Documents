package com.SellerRegistrationservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEncryptableProperties
@OpenAPIDefinition(info=@Info(description="Seller Service Documentation"))
public class SellerRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerRegistrationServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
