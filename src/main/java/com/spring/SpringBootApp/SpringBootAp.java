package com.spring.SpringBootApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootAp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAp.class, args);
		System.out.println("Spring Boot Application Started");
	}

}
