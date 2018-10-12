package com.nzy.eureka.book.user.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nzy.book.user.facade.UserFacade;
import com.nzy.eureka.book.user.service.UserService;

@RestController
public class UserFacadeImpl implements UserFacade {

	@Autowired
	public UserService userService;
	
	@Override
	public Integer login(String userName, String passWord) {
		return this.userService.login(userName, passWord);
	}
}
