package ru.gb.dev.spring.pfs.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * http://localhost:10151/api/statistics
 * http://localhost:10151/api/statistics/ping
 *
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PfsStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfsStatisticsApplication.class, args);
    }

}
