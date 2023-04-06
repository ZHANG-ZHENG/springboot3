package com.zz.test.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/test1")
	public String test1() {
		return "Hello Server " + System.currentTimeMillis();
	}

	@RequestMapping("/test2")
	public String test2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello Server2 " + System.currentTimeMillis();
	}	
}
