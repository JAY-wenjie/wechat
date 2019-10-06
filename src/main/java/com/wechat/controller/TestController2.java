package com.wechat.controller;

import com.wechat.domain.model.DiscountCoupon;
import com.wechat.domain.model.ScoreInfo;
import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;
import com.wechat.service.DiscountCouponService;
import com.wechat.service.ScoreInfoService;
import com.wechat.service.UserCouponService;
import com.wechat.service.UsereScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController2 {
    @Autowired
    UsereScoreService usereScoreService;
    @Autowired
    DiscountCouponService discountCouponService;
    @Autowired
    UserCouponService userCouponService;
    @Autowired
    ScoreInfoService scoreInfoService;

    /**
     * 根据用户id查询用户积分
     * 如果用户之前从未签到过则先建立用户积分表by杨思源
     */
    @RequestMapping(value = "userScore")
    public Map<String,Object> userScore(HttpSession httpSession) {
        WxUser wxUser = new WxUser();
        wxUser.setId(6);
        UserScore userScore = usereScoreService.selectByUserId(wxUser);
        Map<String,Object> map=new HashMap<>();
        map.put("username","123");
        map.put("score",userScore.getScore());
        map.put("days",userScore.getDays());
        return map;
    }

    /**
     * 用户进行签到,更新用户积分、连续天数、最后一次签到时间
     * by杨思源
     */
    @RequestMapping(value = "userSign")
    public boolean userSign(HttpSession httpSession) {
        WxUser wxUser = new WxUser();
        wxUser.setId(6);
        boolean flag = usereScoreService.userSign(wxUser);
        return flag;
    }

    /**
     * 查询展示库存所有优惠券
     * by杨思源
     */
    @RequestMapping(value = "coupons")
    public List<DiscountCoupon> coupons() {
        List<DiscountCoupon> discountCoupons = discountCouponService.selectAll();
        return discountCoupons;
    }

    /**
     * 用户领取优惠券
     * by杨思源
     * 返回1表示领取成功,返回0表示领取失败
     */
    @RequestMapping(value = "addcoupons")
    public int addcoupons() {
        WxUser wxUser = new WxUser();
        wxUser.setId(1);
        DiscountCoupon discountCoupon = new DiscountCoupon();
        discountCoupon.setId(1);
        discountCoupon.setPayScore(5);
        int i = userCouponService.addUserCoupon(wxUser, discountCoupon);
        return i;
    }

    /**
     * 查询用户兑换记录,优惠券和商品
     * by杨思源
     */
    @RequestMapping(value = "document")
    public String document() {
        WxUser wxUser = new WxUser();
        wxUser.setId(1);
        List<ScoreInfo> scoreInfos = scoreInfoService.selectByuserscoreid(wxUser);
        return scoreInfos.toString();
    }
}
