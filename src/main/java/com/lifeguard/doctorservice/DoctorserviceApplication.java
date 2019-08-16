package com.lifeguard.doctorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DoctorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorserviceApplication.class, args);
	}

}
