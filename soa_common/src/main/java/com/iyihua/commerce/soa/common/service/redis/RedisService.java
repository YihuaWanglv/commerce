package com.iyihua.commerce.soa.common.service.redis;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iyihua.commerce.remote.common.redis.RedisRemote;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

@Component
public class RedisService implements RedisRemote {

	@Autowired
	private JedisCluster jedisCluster;

	private int expire = 0;

	// timeout for jedis try to connect to redis server, not expire time! In milliseconds
	private int timeout = 0;

	/**
	 * get value from redis
	 * 
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key) {
		return jedisCluster.get(key);
	}

	/**
	 * set
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(byte[] key, byte[] value) {
		jedisCluster.set(key, value);
		return value;
	}

	/**
	 * set
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(byte[] key, byte[] value, int expire) {
		jedisCluster.set(key, value);
		if (expire != 0) {
			jedisCluster.expire(key, expire);
		}
		return value;
	}

	/**
	 * del
	 * 
	 * @param key
	 */
	public void del(byte[] key) {
		jedisCluster.del(key);
	}

	/**
	 * flush
	 */
	@SuppressWarnings("deprecation")
	public void flushDB() {
		jedisCluster.flushDB();
	}

	/**
	 * size
	 */
	@SuppressWarnings("deprecation")
	public Long dbSize() {
		return jedisCluster.dbSize();
	}

	/**
	 * keys
	 * 
	 * @param regex
	 * @return
	 */
	public Set<byte[]> keys(String pattern) {
		Set<byte[]> keys = new TreeSet<byte[]>();
		Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
		for (String k : clusterNodes.keySet()) {
			JedisPool jp = clusterNodes.get(k);
			Jedis connection = jp.getResource();
			try {
				keys.addAll(connection.keys(pattern.getBytes()));
			} catch (Exception e) {
				System.err.println("Getting keys error: {}" + e.getMessage());
			} finally {
				System.out.println("Connection closed.");
				connection.close();// 用完一定要close这个链接！！！
			}
		}
		System.out.println("Keys gotten!");
		return keys;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}
