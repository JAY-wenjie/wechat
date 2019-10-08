package com.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.wechat.commons.JsonBean;
import com.wechat.commons.JsonUtil;
import com.wechat.domain.model.*;
import com.wechat.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    ScoreSpuService scoreSpuService;
    @Autowired
    NewsService newsService;

    /**
     * 根据用户id查询用户积分
     * 如果用户之前从未签到过则先建立用户积分表by杨思源
     */
    @RequestMapping(value = "userScore")
    public Map<String, Object> userScore(HttpSession session) {
        //获取用户信息
        WxUser wxUser = (WxUser) session.getAttribute("wxuser");
        UserScore userScore = usereScoreService.selectByUserId(wxUser);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "123");
        map.put("score", userScore.getScore());
        map.put("days", userScore.getDays());
        return map;
    }

    /**
     * 用户进行签到,更新用户积分、连续天数、最后一次签到时间
     * by杨思源
     */
    @RequestMapping(value = "userSign")
    public boolean userSign(HttpSession session) {
        //获取用户信息
        WxUser wxUser = (WxUser) session.getAttribute("wxuser");
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
    public boolean addcoupons(Integer id, Integer score, HttpSession session) {
        //获取用户信息
        WxUser wxUser = (WxUser) session.getAttribute("wxuser");
        DiscountCoupon discountCoupon = new DiscountCoupon(id, score);
        boolean flag = userCouponService.addUserCoupon(wxUser, discountCoupon);
        return flag;
    }

    /**
     * 查询用户兑换过的商品
     * by杨思源
     */
    @RequestMapping(value = "document")
    public List<ScoreSpu> document(HttpSession session) {
        //获取用户信息
        WxUser wxUser = (WxUser) session.getAttribute("wxuser");
        List<ScoreSpu> scoreSpus = scoreInfoService.selectByuserscoreid(wxUser);
        return scoreSpus;
    }

    /**
     * 查询可以兑换的所有商品进行展示
     * by杨思源
     */
    @RequestMapping(value = "scoreSpus")
    public List<ScoreSpu> scoreSpus() {
        List<ScoreSpu> scoreSpus = scoreSpuService.selectscoreSpus();
        return scoreSpus;
    }

    /**
     * 根据商品id查询兑换的商品
     * by杨思源
     */
    @RequestMapping(value = "ScoreSpu")
    public ScoreSpu ScoreSpu(Integer id) {
        ScoreSpu scoreSpu = scoreSpuService.selectByid(id);
        return scoreSpu;
    }

    /**
     * 用户用积分兑换商品
     * by杨思源
     */
    @RequestMapping(value = "addgoods")
    public boolean addgoods(Integer id, HttpSession session) {
        //获取用户信息
        WxUser wxUser = (WxUser) session.getAttribute("wxuser");
        boolean flag = scoreSpuService.addgoods(wxUser, id);
        return flag;
    }

    /**
     * 查询全部新闻资讯
     * by杨思源
     */
    @RequestMapping(value = "news")
    public List<News> news() {
        List<News> news = newsService.selectAll();
        return news;
    }

    /**
     * 查询用户的优惠券
     * by杨思源
     */
    @RequestMapping(value = "userCoupons")
    public List<DiscountCoupon> userCoupons(HttpSession session) {
        //获取用户信息
        WxUser wxUser = (WxUser) session.getAttribute("wxuser");
        List<DiscountCoupon> discountCoupons = userCouponService.selectCoupon(wxUser);
        return discountCoupons;
    }

    /**
     * 根据商品积分查询可兑换的商品
     * by杨思源
     */
    @RequestMapping(value = "scoregoods")
    public List<ScoreSpu> scoregoods(Integer score) {
        System.out.println(score);
        List<ScoreSpu> scoreSpus = scoreSpuService.selectByscore(score);
        return scoreSpus;
    }
    /**
     * 根据商品评价查询可兑换的商品
     * by杨思源
     */
    @RequestMapping(value = "goodscomment")
    public List<ScoreSpu> goodscomment(Integer low,Integer high) {
        List<ScoreSpu> scoreSpus = scoreSpuService.selectBycomment(low,high);
        return scoreSpus;
    }
}
