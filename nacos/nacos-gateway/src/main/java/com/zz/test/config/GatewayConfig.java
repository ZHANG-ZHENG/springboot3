package com.zz.test.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.zz.test.filter.CustomGlobalFilter;
import com.zz.test.filter.GrayReactiveLoadBalancerClientFilter;

@Configuration
public class GatewayConfig {

//	@Bean
//	public GlobalFilter customFilter() {
//	    return new CustomGlobalFilter();
//	}
	
	@Bean
	public GrayReactiveLoadBalancerClientFilter grayReactiveLoadBalancerClientFilter() {
		return new GrayReactiveLoadBalancerClientFilter();
	}
}
