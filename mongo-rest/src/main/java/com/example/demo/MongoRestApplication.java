package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MongoRestApplication extends SpringBootServletInitializer {

	/*@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MongoRestApplication.class);
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(MongoRestApplication.class, args);
	}
}
