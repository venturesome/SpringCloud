package com.venture.some.config.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ConfigClientApplication.class, args);
		new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
	}
}
