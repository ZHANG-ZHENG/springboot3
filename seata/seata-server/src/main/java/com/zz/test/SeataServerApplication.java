package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeataServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataServerApplication.class, args);
        System.out.println("应用已启动测试接口访问：http://localhost:7000/seata-server/test/test1");
    }
}