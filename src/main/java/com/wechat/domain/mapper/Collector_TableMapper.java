package com.wechat.domain.mapper;

import com.wechat.domain.model.Collector_Table;

import java.util.List;
import java.util.Map;

public interface Collector_TableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collector_Table record);

    int insertSelective(Collector_Table record);

    Collector_Table selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collector_Table record);

    int updateByPrimaryKey(Collector_Table record);

    /**
     * 查询所有收藏商品
     */
    List<Map<String,Object>> selectAllCollector();
}