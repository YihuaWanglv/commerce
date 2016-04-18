package com.iyihua.commerce.module.soa.message;

import org.springframework.data.redis.listener.ChannelTopic;

import com.iyihua.commerce.model.component.message.RedisMessage;

public interface RedisPublisher {

	public void publish(ChannelTopic topic, RedisMessage message);
}
