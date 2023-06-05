package com.exfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
public class ExampleFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleFeignApplication.class, args);
	}

}
