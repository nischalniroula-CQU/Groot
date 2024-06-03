package com.fyp.groot;

import java.io.IOException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.fyp.groot.entity.Business;
import com.fyp.groot.repository.BusinessRepository;

/**
 * The main class for the Spring Boot application.
 * It contains the main method which is the entry point of the application.
 */
@SpringBootApplication
public class GrootApplication {

    /**
     * The main method which starts the Spring Boot application.
     * 
     * @param args Command line arguments
     * @throws IOException If an input or output exception occurred
     */
    public static void main(String[] args) throws IOException {
        SpringApplication.run(GrootApplication.class, args);
    }

}