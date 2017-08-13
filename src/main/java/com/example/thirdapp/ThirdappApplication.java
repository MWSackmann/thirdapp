package com.example.thirdapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sap.om", "com.example"})
@EntityScan({"com.sap.om", "com.example"})
@EnableJpaRepositories({"com.sap.om", "com.example"})
public class ThirdappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdappApplication.class, args);
	}
}
