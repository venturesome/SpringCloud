package com.venture.some.ribbon.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venture.some.ribbon.service.HelloService;

@RestController
public class HelloControler {

	@Autowired
    HelloService helloService;
	
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name){
        return helloService.hiService(name);
    }
}
