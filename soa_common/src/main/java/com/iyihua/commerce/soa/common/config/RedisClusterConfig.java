package com.iyihua.commerce.soa.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.iyihua.commerce.module.soa.database.RedisConfigManager;

import redis.clients.jedis.JedisCluster;

@Configuration
public class RedisClusterConfig {

	@Value("${redis.cluster.list}")
	private String redisClusterList;
	
	@Bean
	public JedisCluster jedisCluster() {
		Assert.notNull(redisClusterList, "redisClusterList must not be null!");
		return RedisConfigManager.initJedisCluster(redisClusterList);
		
//		Set<HostAndPort> set = new HashSet<>();
//		set.add(new HostAndPort("192.168.1.128", 7000));
//		set.add(new HostAndPort("192.168.1.128", 7001));
//		set.add(new HostAndPort("192.168.1.128", 7002));
//		set.add(new HostAndPort("192.168.1.128", 7003));
//		set.add(new HostAndPort("192.168.1.128", 7004));
//		set.add(new HostAndPort("192.168.1.128", 7005));
//		JedisCluster jedisCluster = new JedisCluster(set);
//		return jedisCluster;
	}

}
