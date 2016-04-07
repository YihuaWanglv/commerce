package com.iyihua.commerce.soa.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
//@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
@EntityScan("com.iyihua.commerce.model.*")  
public class SoaUserBoot 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SoaUserBoot.class, args);
	}
}
