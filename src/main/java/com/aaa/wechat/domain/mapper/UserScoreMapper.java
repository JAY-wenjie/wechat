package com.aaa.wechat.domain.mapper;

import com.aaa.wechat.domain.model.UserScore;

public interface UserScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserScore record);

    int insertSelective(UserScore record);

    UserScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserScore record);

    int updateByPrimaryKey(UserScore record);
}