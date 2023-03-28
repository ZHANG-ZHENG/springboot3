package com.zz.test.user.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.zz.test.server.feign.FeignServer;

@RestController
@RequestMapping("/test2")
public class GreetingController {
    private String cache = "cache";

    @Autowired
    RestTemplate restTemplate;
    
	@Autowired
	private FeignServer feignServer;

    @GetMapping("/test1")
    @CircuitBreaker(name = "greetingCircuit", fallbackMethod = "greetingFallBack")
    public ResponseEntity greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8081/serviceBgreeting?name=" + name, String.class);
        //update cache
        cache = responseEntity.getBody().toString();
        return responseEntity;
    }

    @GetMapping("/test2")
    @CircuitBreaker(name = "greetingCircuit", fallbackMethod = "greetingFallBack2")
    public String test2() {
    	String aaa = feignServer.test1();
        return aaa;
    }
    
    //Invoked when call to serviceB failed
    public ResponseEntity greetingFallBack(String name, Exception ex) {
        System.out.println("Exception occurred when call calling service B");
        //return data from cache
        return ResponseEntity.ok().body("error"+System.currentTimeMillis());
    }
    
    //Invoked when call to serviceB failed
    public String greetingFallBack2(Exception ex) {
        System.out.println("Exception2 occurred when call calling service B");
        return "error"+System.currentTimeMillis();
    }




}