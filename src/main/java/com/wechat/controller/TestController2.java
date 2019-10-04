package com.wechat.controller;

import com.wechat.domain.model.DiscountCoupon;
import com.wechat.domain.model.UserScore;
import com.wechat.domain.model.WxUser;
import com.wechat.service.DiscountCouponService;
import com.wechat.service.UserCouponService;
import com.wechat.service.UsereScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TestController2 {
    @Autowired
    UsereScoreService usereScoreService;
    @Autowired
    DiscountCouponService discountCouponService;
    @Autowired
    UserCouponService userCouponService;

    /**
     * 根据用户id查询用户积分
     * 如果用户之前从未签到过则先建立用户积分表by杨思源
     */
    @RequestMapping(value = "userScore")
    public String userScore(HttpSession httpSession) {
        WxUser wxUser = new WxUser();
        wxUser.setId(1);
        UserScore userScore = usereScoreService.selectByUserId(wxUser);
        return userScore.toString();
    }

    /**
     * 用户进行签到,更新用户积分、连续天数、最后一次签到时间
     * by杨思源
     */
    @RequestMapping(value = "userSign")
    public String userSign(HttpSession httpSession) {
        WxUser wxUser = new WxUser();
        wxUser.setId(1);
        UserScore userScore = usereScoreService.userSign(wxUser);
        return userScore.toString();
    }

    /**
     * 查询展示库存所有优惠券
     * by杨思源
     */
    @RequestMapping(value = "coupons")
    public String coupons() {
        List<DiscountCoupon> discountCoupons = discountCouponService.selectAll();
        return discountCoupons.toString();
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
}
