package ru.gb.dev.spring.pfs.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PfsAuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(PfsAuthenticationApplication.class, args);
    }
}
