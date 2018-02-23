package com.venture.some.zuul.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServiceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ZuulServiceApplication.class, args);
		new SpringApplicationBuilder(ZuulServiceApplication.class).web(true).run(args);
	}
}
