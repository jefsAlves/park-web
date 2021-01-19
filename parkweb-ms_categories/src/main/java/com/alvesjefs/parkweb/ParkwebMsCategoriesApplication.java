package com.alvesjefs.parkweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ParkwebMsCategoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkwebMsCategoriesApplication.class, args);
	}

}
