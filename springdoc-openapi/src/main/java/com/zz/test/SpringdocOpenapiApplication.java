package com.zz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdocOpenapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringdocOpenapiApplication.class, args);
        System.out.println("应用已启动openapi访问：http://localhost:8080/swagger-ui.html");
    }
}