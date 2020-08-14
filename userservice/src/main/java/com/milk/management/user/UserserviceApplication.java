package com.milk.management.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class UserserviceApplication {

	public static void main(String[] args) {
		//Run the app
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
