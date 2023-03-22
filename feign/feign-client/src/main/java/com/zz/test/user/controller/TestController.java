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
	public String hello() {
//		List<ServiceInstance> instances = client.getInstances("HelloServer");
//		ServiceInstance selectedInstance = instances
//				.get(new Random().nextInt(instances.size()));
//		return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
//				.getHost() + ":" + selectedInstance.getPort();
		String feignServerTest1 =  feignServer.test1();
		return "Hello Client,"+feignServerTest1;
	}


	
}
