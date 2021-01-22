package com.alvesjefs.parkweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class ParkwebMsUsersApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ParkwebMsUsersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Pass = " + bCryptPasswordEncoder.encode("JRE@rt56"));
//		System.out.println("Pass = " + bCryptPasswordEncoder.encode("JRES84@k"));
//		System.out.println("Pass = " + bCryptPasswordEncoder.encode("OREA34@"));
	}

}
