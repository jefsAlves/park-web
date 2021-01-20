package com.alvesjefs.parkweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ParkwebConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkwebConfigurationServerApplication.class, args);
	}

}
