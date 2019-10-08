package com.wechat.service.Impl;

import com.wechat.domain.mapper.ScoreInfoMapper;
import com.wechat.domain.mapper.ScoreSpuMapper;
import com.wechat.domain.mapper.UserScoreMapper;
import com.wechat.domain.model.ScoreInfo;
import com.wechat.domain.model.ScoreSpu;
import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;
import com.wechat.service.ScoreSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreSpuServiceImpl implements ScoreSpuService {
    @Autowired
    ScoreSpuMapper scoreSpuMapper;
    @Autowired
    UserScoreMapper userScoreMapper;
    @Autowired
    ScoreInfoMapper scoreInfoMapper;

    /**
     * 查询可以兑换的所有商品
     * by杨思源
     */
    @Override
    public List<ScoreSpu> selectscoreSpus() {
        return scoreSpuMapper.selectscoreSpus();
    }

    @Override
    public ScoreSpu selectByid(Integer id) {
        return scoreSpuMapper.selectByid(id);
    }

    @Override
    public boolean addgoods(WxUser wxUser, Integer id) {
        //查询用户的积分
        UserScore userScore = userScoreMapper.selectByUserId(wxUser);
        //查询要兑换的商品
        ScoreSpu scoreSpu = scoreSpuMapper.selectByid(id);
        Date date = new Date();
        //如果用户积分大于等于商品积分,则兑换成功,返回true
        if (userScore.getScore() >= scoreSpu.getSocre()) {
            //用户积分减少
            UserScore userScore1 = new UserScore(1, wxUser.getId(), scoreSpu.getSocre(), 1, date);
            userScoreMapper.reduceUserScores(userScore1);
            //用户积分详情表记录这次兑换
            ScoreInfo scoreInfo = new ScoreInfo(userScore.getId(), id, "用户兑换商品,积分-" + scoreSpu.getSocre(), date);
            scoreInfoMapper.insert(scoreInfo);
            //积分商品表库存减少
            scoreSpuMapper.reducescoreSpu(id);
            return true;
        } else {
            //如果用户积分小于商品积分,则兑换失败,返回false
            return false;
        }
    }

    @Override
    public List<ScoreSpu> selectByscore(Integer score) {
        List<ScoreSpu> scoreSpus = scoreSpuMapper.selectByscore(score);
        return scoreSpus;
    }

    @Override
    public List<ScoreSpu> selectBycomment(Integer low,Integer high) {
        Map<String,Integer> map=new HashMap<>();
        map.put("low",low);
        map.put("high",high);
        List<ScoreSpu> scoreSpus=scoreSpuMapper.selectBycomment(map);
        return scoreSpus;
    }
}
