package com.venture.some.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hello")
	public String hello() {
		return foo;
	}
}
