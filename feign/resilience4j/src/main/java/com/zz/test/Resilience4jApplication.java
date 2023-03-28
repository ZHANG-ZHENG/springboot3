package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Resilience4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(Resilience4jApplication.class, args);
        System.out.println("应用已启动");
        System.out.println("测试接口访问：http://localhost:7002/resilience4j/test/test1");
        System.out.println("actuator测试接口访问：http://localhost:7002/resilience4j/actuator/health");
        System.out.println("actuator测试接口访问：http://localhost:7002/resilience4j/actuator/info");
        System.out.println("actuator测试接口访问：http://localhost:7002/resilience4j/actuator/beans");
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}