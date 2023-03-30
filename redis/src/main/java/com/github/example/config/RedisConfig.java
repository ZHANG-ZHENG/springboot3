package com.github.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(factory);
//        // key采用String的序列化方式
//        template.setKeySerializer(new StringRedisSerializer());
//        // hash的key也采用String的序列化方式
//        template.setHashKeySerializer(new StringRedisSerializer());
//        // value序列化方式采用jackson
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        // hash的value序列化方式采用jackson
//        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        template.afterPropertiesSet();
//        return template;
//    }

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setKeySerializer(new StringRedisSerializer());
	    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	    return template;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPassword("Ruijie@Redis");
	    return factory;
	}
}

