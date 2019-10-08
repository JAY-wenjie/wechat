package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.OrderInfoMapper;
import com.wechat.domain.model.OrderInfo;
import com.wechat.service.OrderInfoService;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    @Override
    public OrderInfo selectByPrimaryKey(Integer id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OrderInfo> selByStatus(Integer id) {
        return orderInfoMapper.selByStatus(id);
    }

    @Override
    public List<OrderInfo> selAll() {
        return orderInfoMapper.selAll();
    }

}
