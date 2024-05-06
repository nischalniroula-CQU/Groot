package com.fyp.groot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GrootApplication {

	public static void main(String[] args) throws IOException {
			
		SpringApplication.run(GrootApplication.class, args);
	}

}

//@ComponentScan(basePackages = {"com.fyp.groot.service", "com.fyp.groot.controller"})