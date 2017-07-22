package com.rudra.aks.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.rudra.aks.bo.UserBO;

@Repository
public class UserServiceImpl implements UserService {

	/**
	 * the Logger
	 */
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	final String KEY = "USER";
	private HashOperations<String, Integer, Object> redisForHash;
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	@PostConstruct
	private void init() {
		redisForHash = template.opsForHash();
	}
	
	
	/**
	 * Arbitrary objects could be saved into Redis as hashes (maps), 
	 * f.e. let save instance of class User 
	 */
	@Override
	public void saveUser(UserBO userBO) {
		redisForHash.put(KEY, userBO.getUserId(), userBO);
	}

	@Override
	public void updateUser(UserBO userBO) {
		redisForHash.put(KEY, userBO.getUserId(), userBO);
		
	}

	@Override
	public void deleteUserById(int userid) {
		redisForHash.delete(KEY, userid);
	}

	@Override
	public UserBO getUserById(int userid) {
		return (UserBO) redisForHash.get(KEY, userid);
	}

	@Override
	public Map<Object, Object> listUser() {
		return template.opsForHash().entries(KEY);
	}

}
