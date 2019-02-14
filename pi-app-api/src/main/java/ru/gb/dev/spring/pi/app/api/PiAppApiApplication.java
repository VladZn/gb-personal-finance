package ru.gb.dev.spring.pi.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PiAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiAppApiApplication.class, args);
	}

}

