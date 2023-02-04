package com.unitral.ecom_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EComServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComServerApplication.class, args);
	}

}
