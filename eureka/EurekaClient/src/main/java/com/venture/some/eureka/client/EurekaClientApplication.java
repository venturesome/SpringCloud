package com.venture.some.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaClientApplication.class, args);
		new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
		
	}
	
	@Value("${spring.application.name}")
	String serviceName;
	@Value("${server.port}")
	String serverPort;
	
	@RequestMapping("/hello")
    public String hello(String name) {
        return "Hello "+ name + "! @" +serviceName+":"+serverPort;
    }
}
