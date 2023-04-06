package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentinelClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelClientApplication.class, args);
        System.out.println("应用已启动测试接口访问：http://localhost:7001/sentinel-client/test/test1");
    }
}