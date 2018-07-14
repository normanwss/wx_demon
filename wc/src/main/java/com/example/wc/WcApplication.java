package com.example.wc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@MapperScan("com.example.wc.mapper")
@SpringBootApplication
public class WcApplication {

	@Bean
	RedisTemplate redisTemplate(RedisConnectionFactory rcf) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(rcf);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(WcApplication.class, args);
	}
}
