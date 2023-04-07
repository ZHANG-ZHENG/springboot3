package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class SeataClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataClientApplication.class, args);
        System.out.println("测试接口访问：http://localhost:7001/seata-client/test/test1");
    }
}