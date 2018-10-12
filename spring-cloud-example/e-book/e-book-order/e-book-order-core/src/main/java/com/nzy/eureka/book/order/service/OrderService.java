package com.nzy.eureka.book.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzy.book.order.domain.Order;
import com.nzy.eureka.book.order.persistence.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;

	public List<Order> findOrderByUserId(Integer userId) {
		return orderMapper.findOrderByUserId(userId);
	}

	public Integer createOrder(Order obj) {
		this.orderMapper.insertSelective(obj);
		return obj.getId();
	}

	public void updateOrderByTrade(Order obj) {
		this.orderMapper.updateByPrimaryKey(obj);
	}

	public Order findOrderById(Integer id) {
		return this.orderMapper.selectByPrimaryKey(id);
	}
}
