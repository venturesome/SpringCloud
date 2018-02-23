package com.venture.some.ribbon.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix
public class RibbonServiceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(RibbonServiceApplication.class, args);
		new SpringApplicationBuilder(RibbonServiceApplication.class).web(true).run(args);
	}
	
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
