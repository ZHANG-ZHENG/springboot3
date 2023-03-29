package com.zz.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.test.server.feign.FeignServer;


@RestController
@RequestMapping("/test")
public class TestController {
	
//	@Autowired
//	DiscoveryClient client;
	
	@Autowired
	private FeignServer feignServer;
	
	@RequestMapping("/test1")
	public String test1() {
		String feignServerTest1 =  feignServer.test1();
		//String feignServerTest1 = "zz";
		return "Hello Client,"+feignServerTest1;
	}

	/**
	 * http://localhost:7002/resilience4j/test/test2
	 */
	@RequestMapping("/test2")
	public String test2() {
		String feignServerTest1 =  feignServer.sleep(1000);
		//String feignServerTest1 = "zz";
		return "Hello Client test2,"+feignServerTest1;
	}
	
}
