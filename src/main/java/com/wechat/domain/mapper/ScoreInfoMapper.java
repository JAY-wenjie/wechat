package com.wechat.domain.mapper;

import com.wechat.domain.model.ScoreInfo;
import com.wechat.domain.model.UserScore;

import java.util.List;

public interface ScoreInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScoreInfo record);

    int insertSelective(ScoreInfo record);

    ScoreInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScoreInfo record);

    int updateByPrimaryKey(ScoreInfo record);
    /**
     * 根据用户表id查询兑换记录
     * 优惠券和商品
     * by杨思源
     */
    List<ScoreInfo> selectByuserscoreid(UserScore userScore);
}