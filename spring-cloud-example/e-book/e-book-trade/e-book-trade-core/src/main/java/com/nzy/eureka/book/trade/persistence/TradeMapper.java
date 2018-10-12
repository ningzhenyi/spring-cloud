package com.nzy.eureka.book.trade.persistence;

import com.nzy.book.product.trade.domain.Trade;

public interface TradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);
}