package com.nzy.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.nzy.book.user.facade.UserFacade;

@FeignClient(name="e-book-user-core")
public interface UserService extends UserFacade{

}
