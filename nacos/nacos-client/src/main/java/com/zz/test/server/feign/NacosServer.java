package com.zz.test.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="nacos-server")
public interface NacosServer {
	@RequestMapping(value = "/nacos-server/test/test1", method = RequestMethod.GET)
	String test1();
}
