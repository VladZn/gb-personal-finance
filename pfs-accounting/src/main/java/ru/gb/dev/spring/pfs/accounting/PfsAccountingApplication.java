package ru.gb.dev.spring.pfs.accounting;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * http://localhost:10151/api/account/ping
 * http://localhost:10151/api/accounts/ping
 * http://localhost:10151/api/account
 * http://localhost:10151/api/accounts
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PfsAccountingApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(PfsAccountingApplication.class, args);
	}

}
