package com.iyihua.commerce.soa.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
//@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class App 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
