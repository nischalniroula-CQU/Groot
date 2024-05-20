package com.fyp.groot;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fyp.groot.entity.Business;
import com.fyp.groot.repository.BusinessRepository;

@SpringBootApplication
public class GrootApplication {

	public static void main(String[] args) throws IOException {
			
		SpringApplication.run(GrootApplication.class, args);
	}
	
	
//	@Bean
//    public CommandLineRunner loadData(BusinessRepository repository) {
//        return args -> {
//            repository.save(new Business());
//            repository.save(new Business(null, "Jane Smith", "Manager", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
//        };
//    }

}

//@ComponentScan(basePackages = {"com.fyp.groot.service", "com.fyp.groot.controller"})