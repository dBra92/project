package com.prfs.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicesApplication { //hr-worker, nome do projeto do professor

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}

}
