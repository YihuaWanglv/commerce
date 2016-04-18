package com.iyihua.commerce.soa.common.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.iyihua.commerce.model.component.message.RedisMessage;
import com.iyihua.commerce.module.soa.message.RedisPublisher;
import com.iyihua.commerce.remote.common.message.RedisMessageRemote;

@Service
public class RedisMessageService implements RedisMessageRemote {

	@Autowired private RedisPublisher redisPublisher;
	
	@Override
	public void publish(String topic, RedisMessage message) {
		
		redisPublisher.publish(new ChannelTopic("pubsub:"+topic) , message);
	}
	
}
