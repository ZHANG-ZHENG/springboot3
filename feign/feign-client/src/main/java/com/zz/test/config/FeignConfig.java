package com.zz.test.config;


import java.util.concurrent.TimeUnit;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

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

    @Bean
    Logger.Level feignLoggerLevel() {
    	//前提条件,在配置文件中,将日志级别设置为DEBUG.NONE（默认）BASIC HEADERS FULL
        return Logger.Level.FULL;
    }
}
