package com.nzy.eureka.book.order.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nzy.book.order.domain.Order;
import com.nzy.book.order.facade.OrderFacade;
import com.nzy.eureka.book.order.service.OrderService;

@RestController
public class OrderFacadeImpl implements OrderFacade {

	@Autowired
	private OrderService orderService;

	@Override
	public List<Order> findOrderByUserId(Integer userId) {
		return orderService.findOrderByUserId(userId);
	}

	@Override
	public Integer createOrder(@RequestBody Order obj) {
		return orderService.createOrder(obj);
	}

	@Override
	public void updateOrderByTrade(@RequestBody Order obj) {
		orderService.updateOrderByTrade(obj);
	}

	@Override
	public Order findOrderById(Integer id) {
		return orderService.findOrderById(id);
	}
}
