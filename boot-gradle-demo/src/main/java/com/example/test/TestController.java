package com.example.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/test1")
	public String hello() {
		return "Hello Server";
	}


	
}
