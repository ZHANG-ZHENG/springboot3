package com.zz.test.user.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {
	
	@Value("${server.port:unknow}")
    private String serverPort;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping("/test1")
	public String test1() {
		return "Hello Server " + serverPort + " " + System.currentTimeMillis();
	}
	@RequestMapping("/test2")
	public String test2() {
		List<ServiceInstance> instances = discoveryClient.getInstances("nacos-server");
		ServiceInstance selectedInstance = instances.get(new Random().nextInt(instances.size()));
		return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance.getHost() + ":" + selectedInstance.getPort();
	}	
	@RequestMapping("/test3")
	public String test3(@RequestHeader(name="X-Request") String xRequest) {
		System.out.println("X-Request="+xRequest);
		return "Hello Server " + serverPort + " " + System.currentTimeMillis();
	}	
	

	/**
	 * http://localhost:7000/nacos-server/test/sleep?sleep=2000
	 */
	@RequestMapping("/sleep")
	public String sleep(@RequestBody int sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "sleep " + sleep;
	}
	
}
