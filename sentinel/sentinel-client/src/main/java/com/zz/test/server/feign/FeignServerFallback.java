package com.zz.test.server.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignServerFallback implements FeignServer{

	@Override
	public String test1() {
		return "SERVER FAIL";
	}

	@Override
	public String test2() {
		return "SERVER2 FAIL";
	}
	
}
