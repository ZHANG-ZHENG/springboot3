package com.zz.test.config;


import java.util.concurrent.TimeUnit;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.loadbalancer.NacosLoadBalancer;

@Configuration
@EnableFeignClients("com.zz.test.**.feign.**")
public class FeignConfig {

	private int feignOkHttpReadTimeout = 60;
	private int feignConnectTimeout = 60;
	private int feignWriteTimeout = 120;

	@Bean
	public okhttp3.OkHttpClient okHttpClient() {
		return new okhttp3.OkHttpClient.Builder()
				.readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
				.connectTimeout(feignConnectTimeout, TimeUnit.SECONDS)
				.writeTimeout(feignWriteTimeout, TimeUnit.SECONDS)
				.build();
	}

//    @Bean
//    @LoadBalanced
//    public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(Environment environment,
//            LoadBalancerClientFactory loadBalancerClientFactory) {
//		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//		return new RandomLoadBalancer(
//		loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//	}
//    public ReactorLoadBalancer<ServiceInstance> nacosServiceInstanceLoadBalancer(Environment environment,
//            LoadBalancerClientFactory loadBalancerClientFactory,
//            NacosDiscoveryProperties nacosDiscoveryProperties) {
//		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//		return new NacosLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name,nacosDiscoveryProperties);
//	}    
	
}
