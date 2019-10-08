package com.wechat.domain.mapper;

import com.wechat.domain.model.PoductSpu;

import java.util.List;

public interface PoductSpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoductSpu record);

    int insertSelective(PoductSpu record);

    PoductSpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoductSpu record);

    int updateByPrimaryKey(PoductSpu record);

    /**
     * 查询所有spu
     * @return
     */
    List<PoductSpu> selectAllProductSpu();
}