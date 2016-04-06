package com.iyihua.commerce.remote.common.redis;

import java.util.Set;

public interface RedisRemote {
	
	public byte[] get(byte[] key);

	/**
	 * set
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(byte[] key, byte[] value);

	/**
	 * set
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(byte[] key, byte[] value, int expire);

	/**
	 * del
	 * 
	 * @param key
	 */
	public void del(byte[] key);

	/**
	 * flush
	 */
	public void flushDB();

	/**
	 * size
	 */
	public Long dbSize();

	/**
	 * keys
	 * 
	 * @param regex
	 * @return
	 */
	public Set<byte[]> keys(String pattern);
}
