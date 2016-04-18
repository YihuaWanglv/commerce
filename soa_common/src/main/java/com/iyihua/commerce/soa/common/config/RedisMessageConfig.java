package com.iyihua.commerce.soa.common.config;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.iyihua.commerce.module.soa.message.DefaultRedisPublisher;
import com.iyihua.commerce.module.soa.message.Receiver;
import com.iyihua.commerce.module.soa.message.RedisPublisher;



@Configuration
public class RedisMessageConfig {

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, topic());

		return container;
	}
	
//	@Bean
//	MessageListenerAdapter listenerAdapter(RedisMessageListener redisMessageListener) {
//		return new MessageListenerAdapter(redisMessageListener);
//	}

	@Bean
	Receiver receiver(CountDownLatch latch) {
		return new Receiver(latch);
	}

	@Bean
	CountDownLatch latch() {
		return new CountDownLatch(1);
	}

//	@Bean
//	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//		return new StringRedisTemplate(connectionFactory);
//	}
	
	@Bean
    RedisTemplate< String, Object > redisTemplate(RedisConnectionFactory connectionFactory) {
        final RedisTemplate< String, Object > template =  new RedisTemplate< String, Object >();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer( new StringRedisSerializer() );
        template.setHashValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
//        template.setValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }
	
	@Bean
    RedisPublisher redisPublisher(RedisConnectionFactory connectionFactory) {
        return new DefaultRedisPublisher(redisTemplate(connectionFactory));
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic( "pubsub:queue" );
    }
	
	
}
