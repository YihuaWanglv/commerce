package com.iyihua.commerce.module.soa.database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.iyihua.commerce.module.soa.model.component.ClusterInfo;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Component
public class RedisConfigManager {

	public JedisCluster initJedisCluster(String redisClusterList) {
		Assert.notNull(redisClusterList, "redisClusterList must not be null!");
		List<ClusterInfo> list = new ArrayList<ClusterInfo>();
		String[] nodes =  redisClusterList.split(",");
		for (String node : nodes) {
			String[] info = node.split(":");
			list.add(new ClusterInfo(info[0], Integer.parseInt(info[1])));
		}
		Assert.notEmpty(list, "ClusterInfo list must not be empty!");
		Set<HostAndPort> set = new HashSet<>();
		for (ClusterInfo clusterInfo : list) {
			set.add(new HostAndPort(clusterInfo.getIp(), clusterInfo.getPort()));
		}
		JedisCluster jedisCluster = new JedisCluster(set);
		return jedisCluster;
	}

}
