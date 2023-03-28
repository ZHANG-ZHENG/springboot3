package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class FeignClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
        System.out.println("应用已启动");
        System.out.println("测试接口访问：http://localhost:7001/feign-client/test/test1");
        System.out.println("actuator测试接口访问：http://localhost:7001/feign-client/actuator/health");
        System.out.println("actuator测试接口访问：http://localhost:7001/feign-client/actuator/info");
        System.out.println("actuator测试接口访问：http://localhost:7001/feign-client/actuator/beans");
    }
}