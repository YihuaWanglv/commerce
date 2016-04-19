package com.iyihua.commerce.app.mqclient.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import com.iyihua.commerce.model.component.message.RedisMessage;
import com.iyihua.commerce.module.soa.annotation.Channel;
import com.iyihua.commerce.module.soa.message.MessageSerializer;

@Component
@Channel(channel={"test","iyihua"})
public class RedisMessageListener implements MessageListener {
	private static final Logger logger = LoggerFactory.getLogger(RedisMessageListener.class);

	MessageSerializer serializer = new MessageSerializer();

	@Override
	public void onMessage(final Message message, final byte[] pattern) {
		RedisMessage obj = (RedisMessage) serializer.deserialize(message.getBody());

		logger.info(obj.getId() + obj.getMessage() + obj.getData().toString());

	}

}
