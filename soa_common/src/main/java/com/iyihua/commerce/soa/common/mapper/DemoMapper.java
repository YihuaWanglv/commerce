
package com.iyihua.commerce.soa.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.iyihua.commerce.soa.common.model.Demo;

/**
 * @author iyihua
 */
public interface DemoMapper {

	@Select("select * from demo")
	List<Demo> findAll();

}
