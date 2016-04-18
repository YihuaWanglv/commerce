package com.iyihua.commerce.module.web.shiro.redis;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iyihua.commerce.remote.common.redis.RedisRemote;

public class RedisCacheManager implements CacheManager {

	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

	@SuppressWarnings("rawtypes")
	private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

	private RedisRemote redisService;

	public RedisCacheManager() {
		super();
	}
	
	public RedisCacheManager(RedisRemote redisService) {
		super();
		this.redisService = redisService;
	}

	/**
	 * The Redis key prefix for caches
	 */
	private String keyPrefix = "shiro_redis_cache:";

	public RedisRemote getredisService() {
		return redisService;
	}

	public void setredisService(RedisRemote redisService) {
		this.redisService = redisService;
	}

	/**
	 * Returns the Redis session keys prefix.
	 * 
	 * @return The prefix
	 */
	public String getKeyPrefix() {
		return keyPrefix;
	}

	/**
	 * Sets the Redis sessions key prefix.
	 * 
	 * @param keyPrefix
	 *            The prefix
	 */
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		logger.debug("获取名称为: " + name + " 的RedisCache实例");
		Cache c = caches.get(name);
		if (c == null) {
			// initialize the Redis manager instance
			// redisService.init();

			// create a new cache instance
			c = new RedisCache<K, V>(redisService, keyPrefix);

			// add it to the cache collection
			caches.put(name, c);
		}
		return c;
	}

}
