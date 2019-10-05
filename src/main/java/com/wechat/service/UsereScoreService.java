package com.wechat.service;

import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;

public interface UsereScoreService {
    /**
     * 根据用户id查询用户的积分表
     * by杨思源
     */
    UserScore selectByUserId(WxUser wxUser);
    /**
     * 用户签到,修改用户积分、连续天数、最后一次签到时间
     * by杨思源
     */
    boolean  userSign(WxUser wxUser);
}
