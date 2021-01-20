package com.alvesjefs.parkweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ParkwebMsClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkwebMsClientsApplication.class, args);
	}

}
