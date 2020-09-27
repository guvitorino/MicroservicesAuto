package com.vitorino.msautomoveis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsAutomoveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAutomoveisApplication.class, args);
	}

}
