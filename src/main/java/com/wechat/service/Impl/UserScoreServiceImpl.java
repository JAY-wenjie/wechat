package com.wechat.service.Impl;

import com.wechat.domain.mapper.ScoreInfoMapper;
import com.wechat.domain.mapper.UserScoreMapper;
import com.wechat.domain.model.ScoreInfo;
import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;
import com.wechat.service.UsereScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserScoreServiceImpl implements UsereScoreService {
    @Autowired
    UserScoreMapper userScoreMapper;
    @Autowired
    ScoreInfoMapper scoreInfoMapper;

    /**
     * 根据用户id查询用户的积分表
     * by杨思源
     */
    @Override
    public UserScore selectByUserId(WxUser wxUser) {
        //查询用户积分表
        UserScore userScore = userScoreMapper.selectByUserId(wxUser);
        //如果用户从来没有签到过,这建立用户的积分表
        if (userScore == null) {
            userScoreMapper.insertUserScore(wxUser);
            //用户积分和连续签到时间都为0
            userScore = new UserScore(0, 0);
            return userScore;
        }
        //获取当前时间,转换格式为yyyy-MM-dd
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format.format(date);
        Date nowTime = null;
        try {
            nowTime = format.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取最后一次签到时间
        Date lastSign = userScore.getLastSign();
        //对两次时间差进行判断
        int days = (int) ((nowTime.getTime() - lastSign.getTime()) / (1000 * 3600 * 24));
        if (days == 0) {
            System.out.println("显示今天已签到");
        } else if (days == 1) {
            System.out.println("已经连续签到"+userScore.getDays()+"天");
        } else {
            //days超过1天,则用户连续签到数归0
            userScoreMapper.updateUserScoredays(wxUser);
            //再次查询用户积分表
            UserScore userScore1 = userScoreMapper.selectByUserId(wxUser);
            System.out.println("已经连续签到"+userScore1.getDays()+"天");
            return userScore1;
        }
        return userScore;
    }

    /**
     * 用户进行签到,修改用户积分、连续天数、最后一次签到时间
     * by杨思源
     */
    @Override
    public UserScore userSign(WxUser wxUser) {
        //查询用户积分表
        UserScore userScore = userScoreMapper.selectByUserId(wxUser);
        //获取当前时间,转换格式为yyyy-MM-dd
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format.format(date);
        Date nowTime = null;
        try {
            nowTime = format.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取最后一次签到时间
        Date lastSign = userScore.getLastSign();
        //对两次时间差进行判断
        int days = (int) ((nowTime.getTime() - lastSign.getTime()) / (1000 * 3600 * 24));
        if (days == 0) {
            //表示今天已经签到过了,模拟输出
            System.out.println("今天已经签到过了!");
        } else if (days == 1) {
            //如果days=1,则表示昨天签过倒
            UserScore userScore1 = new UserScore(wxUser.getId(), 1, nowTime);
            //对用户积分表进行更新
            userScoreMapper.updateUserScore(userScore1);
            //积分详情表赋值
            ScoreInfo scoreInfo = new ScoreInfo(userScore.getId(), "每日签到奖励10积分",date.toString());
            //积分详情表增加这次操作
            scoreInfoMapper.insert(scoreInfo);
        } else {
            //如果days!=1,则表示昨天没有签到,连续天数变成1
            UserScore userScore1 = new UserScore(wxUser.getId(), null, nowTime);
            //对用户积分表进行更新
            userScoreMapper.updateUserScore(userScore1);
            //积分详情表赋值
            ScoreInfo scoreInfo = new ScoreInfo(userScore.getId(), "每日签到奖励10积分",date.toString());
            scoreInfo.setTime(date);
            //积分详情表增加这次操作
            scoreInfoMapper.insert(scoreInfo);
        }
        //查询用户积分表
        UserScore userScore2 = userScoreMapper.selectByUserId(wxUser);
        return userScore2;
    }
}
