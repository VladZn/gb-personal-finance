package ru.gb.dev.spring.pi.server.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class PiServerProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiServerProxyApplication.class, args);
	}

}

