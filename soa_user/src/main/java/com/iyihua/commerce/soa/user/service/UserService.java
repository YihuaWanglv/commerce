package com.iyihua.commerce.soa.user.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.util.Assert;

import com.iyihua.commerce.model.user.User;
import com.iyihua.commerce.module.util.PasswordSecureHash;
import com.iyihua.commerce.remote.user.UserRemote;
import com.iyihua.commerce.soa.user.mapper.UserMapper;
import com.iyihua.commerce.soa.user.mapper.UserRoleMapper;
import com.iyihua.commerce.soa.user.mapper.UserXmlMapper;
import com.iyihua.commerce.soa.user.repository.UserRepository;

public class UserService implements UserRemote {

	@Autowired private UserMapper userMapper;
	@Autowired private UserRepository userRepository;
	@Autowired private UserXmlMapper userXmlMapper;
	@Autowired private UserRoleMapper userRoleMapper;

	@Override
	public User createUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Assert.notNull(user, "User can not be null!");
		String salt = PasswordSecureHash.createRandom();
		user.setPassword(PasswordSecureHash.hashEncrypt(user.getPassword(), salt));
		user.setSalt(salt);
		user.setCode(DigestUtils.sha1DigestAsHex(user.getCode()+salt));
		user = userRepository.save(user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User findUserByName(String username) {
		User result = null;
		User user = userRepository.findByName(username);
		if (user != null) {
			result = new User();
			BeanUtils.copyProperties(user, result);
		}
		return result;
	}


	@Override
	public User updateUser(User user, Boolean isUpdateSelected) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Assert.notNull(user, "User can not be null!");
		User save = new User();
		BeanUtils.copyProperties(user, save);
		if (isUpdateSelected != null && isUpdateSelected) {
			int r = userXmlMapper.updateUserSelective(save);
			if (r <= 0) {
				return null;
			}
		} else {
			save = userRepository.save(save);
		}
		return user;
	}
	
	@Override
	public User findUserById(Long id) {
		return userMapper.findById(id);
	}
	
	public List<String> findByUserId(Long userId) {
		return userRoleMapper.findByUserId(userId);
	}

}
