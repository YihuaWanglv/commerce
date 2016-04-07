package com.iyihua.bootdemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.commerce.model.user.User;
import com.iyihua.commerce.soa.user.SoaUserBoot;
import com.iyihua.commerce.soa.user.mapper.UserMapper;
import com.iyihua.commerce.soa.user.mapper.UserRoleMapper;
import com.iyihua.commerce.soa.user.repository.UserRepository;
//import com.iyihua.commerce.soa.user.service.UserService;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SoaUserBoot.class)
public class AppTest {
	
//	@Autowired UserService userService;
//	@Autowired UserMapper userMapper;
//	@Autowired UserRoleMapper userRoleMapper;
	@Autowired UserRepository userRepository;
	
	@Test
	public void DemoDbTest() {
//		User u = userMapper.findById(1L);
//		System.err.println("-----------------" + u.getName());
		
//		List<String> roles = userRoleMapper.findByUserId(1L);
//		for (String name : roles) {
//			System.err.println("-----------------" + name); 			
//		}
		
		User u = userRepository.findOne(1L);
		System.err.println("-----------------" + u.getName());
	}
}
