package com.zz.test.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="sentinelServer",url="http://localhost:7000/",fallback=FeignServerFallback.class)
public interface FeignServer {
	@RequestMapping(value = "/sentinel-server/test/test1", method = RequestMethod.GET)
	String test1();
	
	@RequestMapping(value = "/sentinel-server/test/test2", method = RequestMethod.GET)
	String test2();
}
