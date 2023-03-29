package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosServerApplication {
    public static void main(String[] args) {
    	ConfigurableApplicationContext app = (ConfigurableApplicationContext) SpringApplication.run(NacosServerApplication.class, args);
        System.out.println("应用已启动测试接口访问：http://localhost:7000/nacos-server/test/test1");
        
    	//获取nacos配置数据
    	System.out.println(app.getEnvironment().getProperty("test.param1"));
    }
}