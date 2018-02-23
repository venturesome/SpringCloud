package com.venture.some.feign.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix // add hystrix
@EnableHystrixDashboard
public class FeignServiceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(FeignServiceApplication.class, args);
		new SpringApplicationBuilder(FeignServiceApplication.class).web(true).run(args);
	}
}
