package com.example.interbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class InterbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterbankApplication.class, args);
	}

}
