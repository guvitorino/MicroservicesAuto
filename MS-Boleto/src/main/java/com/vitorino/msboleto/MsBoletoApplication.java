package com.vitorino.msboleto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsBoletoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBoletoApplication.class, args);
	}

}
