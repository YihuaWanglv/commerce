package com.iyihua.commerce.soa.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.iyihua.commerce.module.soa.message.DefaultRedisPublisher;
import com.iyihua.commerce.module.soa.message.RedisPublisher;



@Configuration
public class RedisMessageConfig {

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		redisConnectionFactory.setHostName("192.168.1.128");
		redisConnectionFactory.setPort(7000);
		return redisConnectionFactory;
	}
	
//	@Bean
//	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//			MessageListenerAdapter listenerAdapter) {
//
//		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.addMessageListener(listenerAdapter, topic());
//
//		return container;
//	}

//	@Bean
//	Receiver receiver(CountDownLatch latch) {
//		return new Receiver(latch);
//	}
//
//	@Bean
//	CountDownLatch latch() {
//		return new CountDownLatch(1);
//	}

	@Bean
    RedisTemplate< String, Object > redisTemplate(RedisConnectionFactory connectionFactory) {
        final RedisTemplate< String, Object > template =  new RedisTemplate< String, Object >();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer( new StringRedisSerializer() );
        template.setHashValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }
	
	@Bean
    RedisPublisher redisPublisher(RedisConnectionFactory connectionFactory) {
        return new DefaultRedisPublisher(redisTemplate(connectionFactory));
    }

//    @Bean
//    ChannelTopic topic() {
//        return new ChannelTopic( "pubsub:queue" );
//    }
	
	
}
