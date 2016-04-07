package com.iyihua.commerce.soa.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class SoaCommonBoot 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SoaCommonBoot.class, args);
	}
}
