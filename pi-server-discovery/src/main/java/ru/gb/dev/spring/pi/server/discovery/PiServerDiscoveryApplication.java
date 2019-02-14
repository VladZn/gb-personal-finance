package ru.gb.dev.spring.pi.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PiServerDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiServerDiscoveryApplication.class, args);
	}

}
