package com.wechat.service;

import com.wechat.domain.model.ScoreInfo;
import com.wechat.domain.model.ScoreSpu;
import com.wechat.domain.model.WxUser;

import java.util.List;

/**
 * @author:杨思源
 * @Date:
 */
public interface ScoreInfoService {
    /**
     * 查看用户兑换记录
     * by杨思源
     */
    List<ScoreSpu> selectByuserscoreid(WxUser wxUser);
    /**
     * 根据score_id查询所有积分收入支出明细
     * @param id
     * @return
     * @autor 文杰
     */
    List<ScoreInfo> selectByScoreId(Integer id);
}
