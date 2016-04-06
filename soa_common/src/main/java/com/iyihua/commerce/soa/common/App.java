package com.iyihua.commerce.soa.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource("classpath:dubbo.xml")
public class App 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
