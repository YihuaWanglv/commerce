package com.iyihua.commerce.soa.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.iyihua.commerce.model.user.User;
import com.iyihua.commerce.remote.user.UserRemote;
import com.iyihua.commerce.soa.user.mapper.UserMapper;

public class UserService implements UserRemote {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User findUserById(Long id) {
		return userMapper.findById(id);
	}

	

}
