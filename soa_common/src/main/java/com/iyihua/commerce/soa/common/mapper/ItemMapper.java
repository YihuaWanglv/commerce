
package com.iyihua.commerce.soa.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.iyihua.commerce.soa.common.model.Item;

/**
 * @author iyihua
 */
public interface ItemMapper {

	// @Select("select * from items where state = #{state}")
	// City findByState(@Param("state") String state);
	@Select("select * from items")
	List<Item> findAll();

}
