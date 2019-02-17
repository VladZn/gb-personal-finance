package ru.gd.dev.spring.pfs.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import ru.gd.dev.spring.pfs.ui.controller.IndexController;

@SpringBootApplication
@EnableDiscoveryClient
public class PfsUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfsUiApplication.class, args);
    }

}
