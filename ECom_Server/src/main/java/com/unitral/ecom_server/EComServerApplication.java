package com.unitral.ecom_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaServer

public class EComServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComServerApplication.class, args);
	}

}
