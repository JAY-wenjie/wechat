package com.wechat.controller;

import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;
import com.wechat.service.UsereScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestController2 {
    @Autowired
    UsereScoreService usereScoreService;

    /**
     * 根据用户id查询用户积分
     * 如果用户之前从未签到过则先建立用户积分表by杨思源
     */
    @RequestMapping(value = "userScore")
    public String userScore(HttpSession httpSession){
        WxUser wxUser=new WxUser();
        wxUser.setId(1);
        UserScore userScore=usereScoreService.selectByUserId(wxUser);
        return userScore.toString();
    }
    /**
     * 用户进行签到,更新用户积分、连续天数、最后一次签到时间
     * by杨思源
     */
    @RequestMapping(value = "userSign")
    public String userSign(HttpSession httpSession){
        WxUser wxUser=new WxUser();
        wxUser.setId(1);
        UserScore userScore=usereScoreService.userSign(wxUser);
        return userScore.toString();
    }
}
