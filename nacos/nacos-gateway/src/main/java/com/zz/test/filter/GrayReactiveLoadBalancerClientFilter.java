package com.zz.test.filter;

import java.net.URI;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class GrayReactiveLoadBalancerClientFilter implements GlobalFilter, Ordered{



    @Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("GrayReactiveLoadBalancerClientFilter");
		URI url = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
		String schemePrefix = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR);
		System.out.println(url+" "+schemePrefix);
		
        return chain.filter(exchange);
	}

    // 设置加载优先级，-1：优先级最高
    @Override
    public int getOrder() {
        return -1;
    }
}
