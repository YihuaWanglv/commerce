package com.iyihua.bootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.commerce.soa.common.SoaCommonBoot;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SoaCommonBoot.class)
public class AppTest {
	
//	@Autowired MyService myService;
//	
//	@Test
//	public void DemoDbTest() {
//
//		List<Demo> demos = myService.getDemo();
//		for (Demo demo : demos) {
//			System.err.println("-----------------demo:" + demo.toString());
//		}
//	}
	
	@Autowired private JavaMailSender javaMailSender;
	
	@Test
	public void send() {
		SimpleMailMessage msg = new SimpleMailMessage();
	    msg.setFrom("service_commerce@163.com");
	    msg.setTo("wanglvyihua@gmail.com");
	    msg.setSubject("testemail");
	    msg.setText("test");
		javaMailSender.send(msg);
    }
}
