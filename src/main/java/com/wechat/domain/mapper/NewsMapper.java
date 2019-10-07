package com.wechat.domain.mapper;

import com.wechat.domain.model.News;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    /**
     * 查询所有新闻资讯
     * by杨思源
     */
    List<News> selectAll();
}