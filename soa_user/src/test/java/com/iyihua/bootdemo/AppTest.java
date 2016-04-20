package com.iyihua.bootdemo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.commerce.model.user.User;
import com.iyihua.commerce.soa.user.SoaUserBoot;
import com.iyihua.commerce.soa.user.mapper.UserMapper;
import com.iyihua.commerce.soa.user.mapper.UserRoleMapper;
import com.iyihua.commerce.soa.user.repository.UserRepository;
//import com.iyihua.commerce.soa.user.service.UserService;
import com.iyihua.commerce.soa.user.service.UserService;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SoaUserBoot.class)
public class AppTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	@Autowired UserService userService;
	@Autowired UserRepository userRepository;
	
	@Test
	public void DemoDbTest() {
//		User u = userRepository.findOne(1L);
//		System.err.println("-----------------" + u.getName());
		
		
		User user = new User();
		user.setName("testinsert");
		user.setPassword("123456");
		user.setEmail("service_commerce1@163.com");
		try {
			userService.createUser(user);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
