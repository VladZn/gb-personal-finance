package ru.gb.dev.spring.pfs.notifying;

<<<<<<< HEAD
import org.modelmapper.ModelMapper;
=======
>>>>>>> Add entities, dto, services
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
=======
>>>>>>> Add entities, dto, services

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class PfsNotificationApplication {

<<<<<<< HEAD
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

=======
>>>>>>> Add entities, dto, services
    public static void main(String[] args) {
        SpringApplication.run(PfsNotificationApplication.class, args);
    }

}
