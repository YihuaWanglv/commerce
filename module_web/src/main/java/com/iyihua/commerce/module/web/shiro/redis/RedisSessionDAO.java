package com.iyihua.commerce.module.web.shiro.redis;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iyihua.commerce.module.util.SerializeUtils;
import com.iyihua.commerce.remote.common.redis.RedisRemote;

//@Component
public class RedisSessionDAO extends AbstractSessionDAO {

	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

	private int expire = 0;
	private int timeout = 0;
	private RedisRemote redisService;
	/**
	 * The Redis key prefix for the sessions
	 */
	private String keyPrefix = "shiro_redis_session:";
	
	

//	private RedisSessionDAO(Builder b) {
//		super();
//		this.redisService = b.redisService;
//		this.keyPrefix = b.keyPrefix;
//	}
//	
//	public static class Builder {
//		private String keyPrefix = "shiro_redis_session:";
//		private RedisRemote redisService;
//        public Builder(String keyPrefix) {
//            this.keyPrefix = keyPrefix;
//        }
//        public Builder redisRemote(RedisRemote redisService) {
//            this.redisService = redisService;
//            return this;
//        }
//        public RedisSessionDAO build() {
//            return new RedisSessionDAO(this);
//        }
//	}

	public RedisSessionDAO(RedisRemote redisService) {
		super();
		this.redisService = redisService;
	}
	
	public RedisSessionDAO() {
		super();
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
	
	public RedisRemote getRedisService() {
		return redisService;
	}
	
	public void setRedisService(RedisRemote redisService) {
		this.redisService = redisService;
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		this.saveSession(session);
	}

	/**
	 * save session
	 * 
	 * @param session
	 * @throws UnknownSessionException
	 */
	private void saveSession(Session session) throws UnknownSessionException {
		if (session == null || session.getId() == null) {
			logger.error("session or session id is null");
			return;
		}

		byte[] key = getByteKey(session.getId());
		byte[] value = SerializeUtils.serialize(session);
		session.setTimeout(getExpire());
		this.redisService.set(key, value, getExpire());
	}

	@Override
	public void delete(Session session) {
		if (session == null || session.getId() == null) {
			logger.error("session or session id is null");
			return;
		}
		redisService.del(this.getByteKey(session.getId()));
	}

	@Override
	public Collection<Session> getActiveSessions() {
		Set<Session> sessions = new HashSet<Session>();

		Set<byte[]> keys = redisService.keys(this.keyPrefix + "*");
		if (keys != null && keys.size() > 0) {
			for (byte[] key : keys) {
				Session s = (Session) SerializeUtils.deserialize(redisService.get(key));
				sessions.add(s);
			}
		}
		return sessions;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);
		this.assignSessionId(session, sessionId);
		this.saveSession(session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		if (sessionId == null) {
			logger.error("session id is null");
			return null;
		}

		Session s = (Session) SerializeUtils.deserialize(redisService.get(this.getByteKey(sessionId)));
		return s;
	}

	/**
	 * 获得byte[]型的key
	 * 
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(Serializable sessionId) {
		String preKey = this.keyPrefix + sessionId;
		return preKey.getBytes();
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

}
