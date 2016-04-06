package com.iyihua.commerce.soa.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.iyihua.commerce.module.soa.database.RedisConfigManager;

import redis.clients.jedis.JedisCluster;

@Configuration
public class RedisClusterConfig {

	@Autowired private RedisConfigManager redisConfigManager;
	
	@Value("${redis.cluster.list}")
	private String redisClusterList;
	
	@Bean
	public JedisCluster jedisCluster() {
		Assert.notNull(redisClusterList, "redisClusterList must not be null!");
		return redisConfigManager.initJedisCluster(redisClusterList);
	}

}
