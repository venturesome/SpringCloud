package com.venture.some.config.client.cloud.bus;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientCloudBusApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ConfigClientCloudBusApplication.class, args);
		new SpringApplicationBuilder(ConfigClientCloudBusApplication.class).web(true).run(args);
	}
}
