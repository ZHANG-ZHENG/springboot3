package com.zz.test.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("feignServer")
@FeignClient(name="feignServer",url="http://localhost:7000/")
public interface FeignServer {
	@RequestMapping(value = "/seata-server/test/test1", method = RequestMethod.GET)
	String test1();
}
