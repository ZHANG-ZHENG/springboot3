package com.zz.test.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;


@FeignClient(name="feignServer",url="http://localhost:7000/")
public interface FeignServer {
	
	static final String BACKEND_A = "backendA";
	
	@RequestMapping(value = "/feign-server/test/test1", method = RequestMethod.GET)
	@CircuitBreaker(name = BACKEND_A, fallbackMethod = "getUserFallback")
	String test1();
	
	@RequestMapping(value = "/feign-server/test/sleep", method = RequestMethod.GET)
	@CircuitBreaker(name = BACKEND_A, fallbackMethod = "defaultFallback")
	String sleep(@RequestBody int sleep);
	
	@RequestMapping(value = "/feign-server/test/test1", method = RequestMethod.GET)
	@Retry(name = BACKEND_A, fallbackMethod = "doSomethingFallback")
	String testRetry();
	
    default String defaultFallback(Exception e) {
    	System.out.println("defaultFallback " + e.getMessage());
    	//e.printStackTrace();
        return null;
    }
	
    default String getUserFallback(Exception exc) {
        return "default value";
    }
    
    

    //方法名必须与@Retry注解的fallbackMethod参数的值一致
    //返回类型必须与Retry注解的方法的返回类型一致
    //必须传入Throwable参数
    default String doSomethingFallback(Throwable t){
        //fallback逻辑，只有重试次数用完了才会运行此代码
    	System.out.println("doSomethingFallback1");
    	return "doSomethingFallback";
    }
 
    //可以用更加明确的异常类型，Retry会优先使用匹配得更加准确的fallback方法。
    default String doSomethingFallback(RuntimeException e){
        //fallback逻辑
    	System.out.println("doSomethingFallback2");
    	return "doSomethingFallback";
    }
 
    //可以传入注解了@Retry的方法的参数
    default String doSomethingFallback(String someinput, Throwable t){
        //fallback逻辑
    	System.out.println("doSomethingFallback3");
    	return "doSomethingFallback";
    }
}
