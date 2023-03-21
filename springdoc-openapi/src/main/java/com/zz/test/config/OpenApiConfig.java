package com.zz.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	//https://blog.csdn.net/wangzhihao1994/article/details/108408595
	public OpenAPI customOpenAPI() {//@Value("${springdoc.version}") String appVersion
	 return new OpenAPI()
	        //.components(new Components().addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
	        //.addParameters("myHeader1", new Parameter().in("header").schema(new StringSchema()).name("myHeader1")).addHeaders("myHeader2", new Header().description("myHeader2 header").schema(new StringSchema())))
	        .info(new Info()
	        .title("OpenAPI标题")
	        .version("1.1.1")
	        .description("OpenAPI描述")
	        //.termsOfService("http://swagger.io/terms/")
	        //.license(new License().name("Apache 2.0").url("http://springdoc.org"))
	        )
	        ;
	}
	
}
