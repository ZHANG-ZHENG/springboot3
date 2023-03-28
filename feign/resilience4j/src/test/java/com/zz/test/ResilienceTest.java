package com.zz.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zz.test.server.feign.FeignServer;

import io.github.resilience4j.circuitbreaker.CircuitBreaker.Metrics;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@SpringBootTest
class ResilienceTest {

    @Autowired
    private FeignServer feignServer;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Test
    void test() throws Exception {
        for (int i = 0; i < 100; i++) {
        	feignServer.test1();
            Thread.sleep(1000);
            status();
        }
    }

    private void status() {
    	System.out.println(circuitBreakerRegistry);
    	io.github.resilience4j.circuitbreaker.CircuitBreaker breaker = circuitBreakerRegistry.circuitBreaker("greetingCircuit");
        Metrics metrics = breaker.getMetrics();
        System.out.println("state="+breaker.getState()+",metrics[failureRate="+metrics.getFailureRate()+",bufferedCalls="+metrics.getNumberOfBufferedCalls()+",failedCalls="+metrics.getNumberOfFailedCalls()+",successCalls="+metrics.getNumberOfSuccessfulCalls()+",maxBufferCalls="+metrics.getNumberOfBufferedCalls()+",notPermittedCalls="+metrics.getNumberOfNotPermittedCalls()+"]");
    }

}