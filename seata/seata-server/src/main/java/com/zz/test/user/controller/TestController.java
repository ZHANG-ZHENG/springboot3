package com.zz.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.test.user.service.UserService;



@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test1")
	public String hello() {
		userService.update();
		return "Hello Server " + System.currentTimeMillis();
	}


	
}
