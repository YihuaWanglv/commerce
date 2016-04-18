package com.iyihua.commerce.module.soa.message;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import com.iyihua.commerce.model.component.message.RedisMessage;

public class DefaultRedisPublisher implements RedisPublisher {

	private final RedisTemplate<String, Object> template;
	MessageSerializer serializer = new MessageSerializer();

	public DefaultRedisPublisher(final RedisTemplate<String, Object> template) {
		this.template = template;
	}

	@Override
	public void publish(ChannelTopic topic, RedisMessage message) {
		template.convertAndSend(topic.getTopic(), message);
	}

}
