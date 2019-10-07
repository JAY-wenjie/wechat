package com.wechat.domain.mapper;

import com.wechat.domain.model.PoductSpu;

public interface PoductSpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoductSpu record);

    int insertSelective(PoductSpu record);

    PoductSpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoductSpu record);

    int updateByPrimaryKey(PoductSpu record);
}