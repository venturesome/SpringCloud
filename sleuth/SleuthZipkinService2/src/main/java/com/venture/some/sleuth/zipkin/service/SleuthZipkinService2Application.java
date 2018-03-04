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
public class SleuthZipkinService2Application {

	private static final Logger LOG = Logger.getLogger(SleuthZipkinService2Application.class.getName());

	public static void main(String[] args) {
		// SpringApplication.run(SleuthZipkinService2Application.class, args);
		new SpringApplicationBuilder(SleuthZipkinService2Application.class).web(true).run(args);
	}

	@RequestMapping("/hello")
	public String home() {
		LOG.log(Level.INFO, "hi is being called");
		return "hi i'm venture!";
	}

	@RequestMapping("/venture")
	public String info() {
		LOG.log(Level.INFO, "info is being called");
		return restTemplate.getForObject("http://localhost:8988/info", String.class);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
