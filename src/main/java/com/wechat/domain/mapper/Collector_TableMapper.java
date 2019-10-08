package com.wechat.domain.mapper;

import com.wechat.domain.model.Collector_Table;

public interface Collector_TableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collector_Table record);

    int insertSelective(Collector_Table record);

    Collector_Table selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collector_Table record);

    int updateByPrimaryKey(Collector_Table record);
}