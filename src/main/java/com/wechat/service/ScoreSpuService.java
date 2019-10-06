package com.wechat.service;

import com.wechat.domain.model.ScoreSpu;
import com.wechat.domain.model.WxUser;

import java.util.List;

public interface ScoreSpuService {
    /**
     * 查询所有可以兑换的商品
     * by杨思源
     */
    List<ScoreSpu> selectscoreSpus();
    /**
     * 根据id查询兑换的商品
     * by杨思源
     */
    ScoreSpu selectByid(Integer id);
    /**
     * 用户用积分兑换商品
     * by杨思源
     */
    boolean addgoods(WxUser wxUser,Integer id);
}
