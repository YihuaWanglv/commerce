package com.iyihua.commerce.remote.common.message;

import com.iyihua.commerce.model.component.message.RedisMessage;

public interface RedisMessageRemote {

	public void publish(String topic, RedisMessage message);
}
