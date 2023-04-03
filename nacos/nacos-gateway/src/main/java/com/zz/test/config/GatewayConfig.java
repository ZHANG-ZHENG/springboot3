package com.zz.test.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.zz.test.filter.CustomGlobalFilter;

@Configuration
public class GatewayConfig {

	@Bean
	//@Order(-1)//值越小过滤器越优先执行
	public GlobalFilter customFilter() {
	    return new CustomGlobalFilter();
	}
	
}
