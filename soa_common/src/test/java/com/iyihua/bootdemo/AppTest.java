package com.iyihua.bootdemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.commerce.soa.common.SoaCommonBoot;
import com.iyihua.commerce.soa.common.model.Demo;
import com.iyihua.commerce.soa.common.service.MyService;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SoaCommonBoot.class)
public class AppTest {
	
	@Autowired MyService myService;
	
	@Test
	public void DemoDbTest() {

		List<Demo> demos = myService.getDemo();
		for (Demo demo : demos) {
			System.err.println("-----------------demo:" + demo.toString());
		}
	}
}
