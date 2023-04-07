package com.zz.test.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.test.server.feign.FeignServer;


@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private FeignServer feignServer;
	
	
	@RequestMapping("/test1")
	public String hello() {
		String feignServerTest1 =  feignServer.test1();
		return "Hello Client,"+feignServerTest1;
	}

	@RequestMapping("/test2")
	public String hello2() {
		return "Hello Client 2";
	}
	
}
