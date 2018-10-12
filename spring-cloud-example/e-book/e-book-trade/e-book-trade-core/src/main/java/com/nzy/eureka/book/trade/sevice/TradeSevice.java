package com.nzy.eureka.book.trade.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzy.book.product.trade.domain.Trade;
import com.nzy.eureka.book.trade.persistence.TradeMapper;

@Service
public class TradeSevice {
	
	@Autowired
	private TradeMapper tradeMapper;
	
	public void createTrade(Trade obj){
		this.tradeMapper.insertSelective(obj);
	}
}
