package com.venture.some.sleuth.zipkin.service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SleuthZipkinServiceApplication {

	private static final Logger log = Logger.getLogger(SleuthZipkinServiceApplication.class.getName());
	
	public static void main(String[] args) {
		// SpringApplication.run(SleuthZipkinServiceApplication.class, args);
		new SpringApplicationBuilder(SleuthZipkinServiceApplication.class).web(true).run(args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/hello")
	public String callHome() {
		log.log(Level.INFO, "calling trace service-hello");
		return restTemplate.getForObject("http://localhost:8989/venture", String.class);
	}

	@RequestMapping("/info")
	public String info() {
		log.log(Level.INFO, "calling trace service-hello");

		return "I'm service-hello";

	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
