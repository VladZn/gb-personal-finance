package ru.gd.dev.spring.pi.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PfsNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfsNotificationApplication.class, args);
    }
}
