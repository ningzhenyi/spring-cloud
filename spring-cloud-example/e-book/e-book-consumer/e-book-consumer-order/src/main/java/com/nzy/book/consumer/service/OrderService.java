package com.nzy.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.nzy.book.order.facade.OrderFacade;

@FeignClient(name="e-book-order-core")
public interface OrderService extends OrderFacade{

}
