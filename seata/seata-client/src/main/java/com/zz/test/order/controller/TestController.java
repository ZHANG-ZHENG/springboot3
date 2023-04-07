package com.zz.test.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.test.order.service.UserOrderService;
import com.zz.test.server.feign.FeignServer;


@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserOrderService userOrderService;
	
	
	@RequestMapping("/test1")
	public String test1() {
		userOrderService.update();
		return "Hello Client";
	}

	@RequestMapping("/test2")
	public String test2() {
		userOrderService.update2();
		return "Hello Client";
	}	
}
