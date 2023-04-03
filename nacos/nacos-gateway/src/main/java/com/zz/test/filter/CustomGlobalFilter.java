package com.zz.test.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpStatus;

import reactor.core.publisher.Mono;

public class CustomGlobalFilter implements GlobalFilter {

	/**
	 * 自定义过滤器
	 */
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("custom global filter");
		ServerHttpRequest request = exchange.getRequest();
		ServerHttpResponse response = exchange.getResponse();
		
		MultiValueMap<String, String> params = request.getQueryParams();
		String toekn = params.getFirst("token");
		if("admin".equals(toekn)) {
			return chain.filter(exchange);//放行
		}else {
			System.out.println("用户验证失败。toekn="+toekn);
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			return response.setComplete();
		}
		
		
	}




}
