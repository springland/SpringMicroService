package com.springland365.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrganizationsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationsvcApplication.class, args);
	}

}
