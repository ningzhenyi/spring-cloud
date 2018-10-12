package com.nzy.book.product.trade.facade;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nzy.book.product.trade.domain.Trade;

@RequestMapping("/trade")
public interface TradeFacade {

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<Trade> getTrade();

	@RequestMapping(value = "get", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public Trade getTrade(@RequestParam("id") Integer id);

	@RequestMapping(value = "get", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Trade getTrade1(@RequestBody Trade obj);
	
	@RequestMapping(value = "/createTrade", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createTrade(Trade obj);
}
