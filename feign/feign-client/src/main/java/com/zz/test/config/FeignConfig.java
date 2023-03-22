package com.zz.test.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.zz.test.**.feign.**")
public class FeignConfig {

	
}
