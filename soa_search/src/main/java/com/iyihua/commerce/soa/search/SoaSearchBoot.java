package com.iyihua.commerce.soa.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource("classpath:dubbo.xml")
//@EnableElasticsearchRepositories(basePackages = {"com.iyihua.commerce.soa.search.repository"})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SoaSearchBoot 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SoaSearchBoot.class, args);
	}
}
