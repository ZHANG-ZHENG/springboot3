package com.zz.test.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {
	
//	@Autowired
//	DiscoveryClient client;
	
	@RequestMapping("/test1")
	public String hello() {
//		List<ServiceInstance> instances = client.getInstances("HelloServer");
//		ServiceInstance selectedInstance = instances
//				.get(new Random().nextInt(instances.size()));
//		return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
//				.getHost() + ":" + selectedInstance.getPort();
		return "Hello Server " + System.currentTimeMillis();
	}

	/**
	 * http://localhost:7000/feign-server/test/sleep?sleep=2000
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
