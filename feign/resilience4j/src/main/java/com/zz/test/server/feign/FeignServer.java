package com.zz.test.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name="feignServer",url="http://localhost:7000/")
public interface FeignServer {
	@RequestMapping(value = "/feign-server/test/test1", method = RequestMethod.GET)
	@CircuitBreaker(name = "greetingCircuit", fallbackMethod = "getUserFallback")
	String test1();
	
    default String getUserFallback(Exception exc) {
        return "default value";
    }
    
//    default String getUserFallback2(Exception exc) {
//        return "default value2";
//    }
}
