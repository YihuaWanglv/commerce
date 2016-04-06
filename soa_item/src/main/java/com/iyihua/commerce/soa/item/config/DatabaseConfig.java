package com.iyihua.commerce.soa.item.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iyihua.commerce.module.soa.database.BaseDatabaseManager;

@Configuration
@MapperScan(basePackages="com.iyihua.commerce.soa.item.mapper")
public class DatabaseConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		return BaseDatabaseManager.initSqlSessionFactory(dataSource);
	}

}
