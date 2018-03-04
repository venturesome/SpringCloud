package com.venture.some.sleuth.zipkin.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SleuthZipkinServerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SleuthZipkinServerApplication.class, args);
		new SpringApplicationBuilder(SleuthZipkinServerApplication.class).web(true).run(args);
	}
}
