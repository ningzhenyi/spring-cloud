package com.nzy.eureka.book.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzy.eureka.book.user.persistence.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public Integer login(String userName, String passWord) {
		return this.userMapper.login(userName, passWord);
	};
}
