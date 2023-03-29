package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
        System.out.println("应用已启动");
        System.out.println("测试接口访问：http://localhost:6911/nacos-client/test/test1");
        System.out.println("actuator测试接口访问：http://localhost:6911/nacos-client/actuator/health");
        System.out.println("actuator测试接口访问：http://localhost:6911/nacos-client/actuator/info");
        System.out.println("actuator测试接口访问：http://localhost:6911/nacos-client/actuator/beans");
    }
}