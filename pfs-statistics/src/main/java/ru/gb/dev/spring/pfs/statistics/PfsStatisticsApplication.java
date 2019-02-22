package ru.gb.dev.spring.pfs.statistics;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * http://localhost:10152/api/categories
 * http://localhost:10152/api/clients
 * http://localhost:10152/api/logos
 * http://localhost:10152/api/operations
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PfsStatisticsApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(PfsStatisticsApplication.class, args);
	}

}
