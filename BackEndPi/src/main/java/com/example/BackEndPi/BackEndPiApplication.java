package com.example.BackEndPi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}", version = "${info.build.version}", description = "${info.app.description}",
		contact = @io.swagger.v3.oas.annotations.info.Contact(name = "", email = "")))
@SpringBootApplication
public class BackEndPiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndPiApplication.class, args);
	}

}
