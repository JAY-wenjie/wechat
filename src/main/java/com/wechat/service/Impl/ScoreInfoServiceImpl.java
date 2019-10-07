package com.wechat.service.Impl;

import com.wechat.domain.mapper.ScoreInfoMapper;
import com.wechat.domain.mapper.ScoreSpuMapper;
import com.wechat.domain.mapper.UserScoreMapper;
import com.wechat.domain.model.ScoreInfo;
import com.wechat.domain.model.ScoreSpu;
import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;
import com.wechat.service.ScoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:杨思源
 * @Date:
 */
@Service
public class ScoreInfoServiceImpl implements ScoreInfoService {
    @Autowired
    UserScoreMapper userScoreMapper;
    @Autowired
    ScoreInfoMapper scoreInfoMapper;
    @Autowired
    ScoreSpuMapper scoreSpuMapper;

    /**
     * 查看用户兑换记录,优惠券和商品
     * by杨思源
     */
    @Override
    public List<ScoreSpu> selectByuserscoreid(WxUser wxUser) {
        //查询用户的积分表
        UserScore userScore = userScoreMapper.selectByUserId(wxUser);
        //查询用户的积分详情
        List<ScoreInfo> scoreInfos = scoreInfoMapper.selectByuserscoreid(userScore);
        //存储id的list集合
        List<Integer> list=new ArrayList<>();
        for (ScoreInfo scoreInfo : scoreInfos) {
            list.add(scoreInfo.getSpuId());
        }
        //list集合去重
        List newList = list.stream().distinct().collect(Collectors.toList());
        //查询兑换过的商品详细信息
        List<ScoreSpu> scoreSpus=scoreSpuMapper.selectByids(newList);
        return scoreSpus;
    }

    /**
     * 根据score_id查询所有积分收入支出明细
     * @param id
     * @return
     * @autor 文杰
     */
    @Override
    public List<ScoreInfo> selectByScoreId(Integer id) {

        return scoreInfoMapper.selectByScoreId(id);
    }
}
