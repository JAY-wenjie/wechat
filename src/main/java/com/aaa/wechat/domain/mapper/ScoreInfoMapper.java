package com.aaa.wechat.domain.mapper;

import com.aaa.wechat.domain.model.ScoreInfo;

public interface ScoreInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScoreInfo record);

    int insertSelective(ScoreInfo record);

    ScoreInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScoreInfo record);

    int updateByPrimaryKey(ScoreInfo record);
}