package com.rudra.aks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.rudra.aks.bo.UserBO;
import com.rudra.aks.converter.UserBOConverter;

@ComponentScan(basePackages="com.rudra.aks")
@Configuration
public class AppConfiguration {

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setKeySerializer( new StringRedisSerializer() );
	    //template.setHashValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
	    //template.setHashKeySerializer( new StringRedisSerializer() );
	    template.setValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
	    return template;
	    
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		//return new JedisConnectionFactory();
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
	    jedisConFactory.setHostName("localhost");
	    jedisConFactory.setPort(6379);
	    return jedisConFactory;
	}
	
	@Bean
	public ConversionService coverterService() {
		GenericConversionService converterSerivce = new GenericConversionService();
		converterSerivce.addConverter(UserBO.class, String.class, new UserBOConverter());
		return converterSerivce;
	}
}
