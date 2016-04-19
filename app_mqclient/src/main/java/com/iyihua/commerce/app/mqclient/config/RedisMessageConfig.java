package com.iyihua.commerce.app.mqclient.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import com.iyihua.commerce.model.common.GlobalStaticVariable;
import com.iyihua.commerce.module.soa.annotation.ChannelAnnotationParser;

@Configuration
public class RedisMessageConfig {

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		redisConnectionFactory.setHostName("192.168.1.128");
		redisConnectionFactory.setPort(7000);
		return redisConnectionFactory;
	}

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, List<MessageListener> listeners) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		for (MessageListener listener : listeners) {
			String[] channels = ChannelAnnotationParser.getChannels(listener);
			for (String channel : channels) {
				container.addMessageListener(listener,
						new ChannelTopic(GlobalStaticVariable.REDIS_MESSAGE_TOTIC_PREFIX + channel));
			}
		}

		return container;
	}

}
