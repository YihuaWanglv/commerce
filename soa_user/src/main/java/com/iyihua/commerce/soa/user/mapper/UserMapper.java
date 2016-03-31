
package com.iyihua.commerce.soa.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iyihua.commerce.model.user.User;

/**
 * @author iyihua
 */
public interface UserMapper {

	@Select("select * from user where id = #{id}")
	User findById(@Param("id") Long id);

}
