package com.nzy.book.user.facade;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
public interface UserFacade {

	@RequestMapping(value = "/login", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	Integer login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord);

}
