package com.wechat.domain.mapper;

import com.wechat.domain.model.ScoreSpu;

import java.util.List;
import java.util.Map;

public interface ScoreSpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScoreSpu record);

    int insertSelective(ScoreSpu record);

    ScoreSpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScoreSpu record);

    int updateByPrimaryKey(ScoreSpu record);

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
     * 用户兑换成功后,商品库存-1
     * by杨思源
     */
    int reducescoreSpu(Integer id);
    /**
     * 根据id查询兑换的商品记录
     * by杨思源
     */
    List<ScoreSpu> selectByids(List<Integer> ids);
    /**
     * 根据商品积分查询商品
     */
    List<ScoreSpu> selectByscore(Integer score);
    /**
     * 根据商品评分查询商品
     */
    List<ScoreSpu> selectBycomment(Map<String,Integer> map);

}