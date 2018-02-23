package com.venture.some.feign.service.hystrix;

import org.springframework.stereotype.Component;

import com.venture.some.feign.service.service.HelloService;

@Component
public class HelloServiceHystrix implements HelloService {

	@Override
	public String sayHiFromClientOne(String name) {
		
		return "Sorry," + name;
	}

}
