package com.nzy.book.order.facade;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nzy.book.order.domain.Order;

@RequestMapping("/order")
public interface OrderFacade {

	@RequestMapping(value = "find", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	List<Order> findOrderByUserId(@RequestParam("userId") Integer userId);

	@RequestMapping(value = "create", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	Integer createOrder(@RequestBody Order obj);

	@RequestMapping(value = "update", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	void updateOrderByTrade(@RequestBody Order obj);

	@RequestMapping(value = "get", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	Order findOrderById(@RequestParam("id") Integer id);
}
