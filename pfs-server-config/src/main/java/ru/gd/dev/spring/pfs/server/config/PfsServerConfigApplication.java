package ru.gd.dev.spring.pfs.server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * http://127.0.0.1:8888/pi-server-discovery.properties
 * http://127.0.0.1:8888/pi-app-api.properties
 * http://127.0.0.1:8888/pi-app-web.properties
 */

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class PfsServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfsServerConfigApplication.class, args);
	}

}

