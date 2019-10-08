package com.wechat.service;

import com.wechat.domain.model.OrderInfo;

import java.util.List;

public interface OrderInfoService{


    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> selAll();
    List<OrderInfo> selByStatus(Integer id);

}
