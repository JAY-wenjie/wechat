package com.wechat.service;

import com.wechat.domain.model.Collector_Table;
public interface Collector_TableService{


    int deleteByPrimaryKey(Integer id);

    int insert(Collector_Table record);

    int insertSelective(Collector_Table record);

    Collector_Table selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collector_Table record);

    int updateByPrimaryKey(Collector_Table record);

}
