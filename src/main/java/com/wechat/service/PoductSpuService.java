package com.wechat.service;

import com.wechat.domain.model.PoductSpu;
public interface PoductSpuService{


    int deleteByPrimaryKey(Integer id);

    int insert(PoductSpu record);

    int insertSelective(PoductSpu record);

    PoductSpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoductSpu record);

    int updateByPrimaryKey(PoductSpu record);

}
