package com.nzy.eureka.book.user.persistence;

import org.apache.ibatis.annotations.Param;

import com.nzy.book.user.domain.User;

public interface UserMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	Integer login(@Param("userName") String userName, @Param("passWord") String passWord);
}