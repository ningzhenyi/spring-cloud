package com.nzy.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.nzy.book.product.trade.facade.TradeFacade;

@FeignClient(name="e-book-trade-core")
public interface TradeService extends TradeFacade{

}
