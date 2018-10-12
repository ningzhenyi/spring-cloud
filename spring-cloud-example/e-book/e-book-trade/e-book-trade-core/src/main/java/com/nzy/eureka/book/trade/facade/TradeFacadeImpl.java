package com.nzy.eureka.book.trade.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nzy.book.order.domain.Order;
import com.nzy.book.product.trade.domain.Trade;
import com.nzy.book.product.trade.facade.TradeFacade;
import com.nzy.eureka.book.trade.sevice.OrderService;
import com.nzy.eureka.book.trade.sevice.TradeSevice;

@RestController
public class TradeFacadeImpl implements TradeFacade {

	@Autowired
	private TradeSevice tradeSevice;
	
	@Autowired
	private OrderService orderService;

	@Override
	public List<Trade> getTrade() {
		return null;
	}

	@Override
	public Trade getTrade(Integer id) {
		return null;
	}

	@Override
	public Trade getTrade1(Trade obj) {
		return null;
	}

	@Override
	public void createTrade(@RequestBody Trade obj) {
		this.tradeSevice.createTrade(obj);
		// 回填 订单里面的交易号
		Order order = this.orderService.findOrderById(obj.getOrderId());
//		Order order=new Order();
//		order.setId(obj.getId());
		order.setTradeId(obj.getId());
		order.setTradeStatus(true);
		this.orderService.updateOrderByTrade(order);
	}
}
