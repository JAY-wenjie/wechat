package com.wechat.domain.mapper;

import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;

public interface UserScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserScore record);

    int insertSelective(UserScore record);

    UserScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserScore record);

    int updateByPrimaryKey(UserScore record);
    /**
     * 根据用户id查询用户的积分表
     * by杨思源
     */
    UserScore selectByUserId(WxUser wxUser);
    /**
     * 根据用户id建立用户的积分表
     * by杨思源
     */
    int insertUserScore(WxUser wxUser);
    /**
     * 用户签到,修改用户积分、连续签到时间、最后签到时间
     * by杨思源
     */
    int updateUserScore(UserScore userScore);
    /**
     * 用户断签,连续签到数归0
     */
    int updateUserScoredays(WxUser wxUser);
    /**
     * 用户积分减少
     */
    int reduceUserScores(UserScore userScore);
}