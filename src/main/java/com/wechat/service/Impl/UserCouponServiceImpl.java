package com.wechat.service.Impl;

import com.wechat.domain.mapper.DiscountCouponMapper;
import com.wechat.domain.mapper.ScoreInfoMapper;
import com.wechat.domain.mapper.UserCouponMapper;
import com.wechat.domain.mapper.UserScoreMapper;
import com.wechat.domain.model.*;
import com.wechat.service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:杨思源
 * @Date:
 */
@Service
public class UserCouponServiceImpl implements UserCouponService {
    @Autowired
    DiscountCouponMapper discountCouponMapper;
    @Autowired
    UserScoreMapper userScoreMapper;
    @Autowired
    UserCouponMapper userCouponMapper;
    @Autowired
    ScoreInfoMapper scoreInfoMapper;

    /**
     * 用户兑换优惠券
     * by杨思源
     */
    @Override
    public boolean addUserCoupon(WxUser wxUser, DiscountCoupon discountCoupon) {
        //查询用户的积分
        UserScore userScore = userScoreMapper.selectByUserId(wxUser);
        if (userScore.getScore() >= discountCoupon.getPayScore()) {
            //如果用户积分>=兑换所需积分,则兑换成功
            UserCoupon userCoupon = new UserCoupon(wxUser.getId(), discountCoupon.getId(), 0);
            //用户优惠券表中插入数据
            userCouponMapper.insert(userCoupon);
            //优惠券表中优惠券库存-1
            discountCouponMapper.reduceDiscountCoupon(discountCoupon);
            //时间格式转换,精确到秒
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            //用户积分减少
            UserScore userScore1 = new UserScore(userScore.getId(), userScore.getUserId(),
                    discountCoupon.getPayScore(), 1, date);
            userScoreMapper.reduceUserScores(userScore1);
            //用户积分详情表更新,记录这次兑换
            ScoreInfo scoreInfo = new ScoreInfo(userScore.getId(), "用户兑换优惠券,积分-" + discountCoupon.getPayScore(), date);
            scoreInfoMapper.insert(scoreInfo);
            //返回1表示成功领取
            System.out.println("您已成功领取优惠券");
            return true;
        } else {
            //如果用户积分<兑换所需积分,则兑换失败
            System.out.println("您的积分不足,领取失败");
            //返回0表示领取失败
            return false;
        }
    }

    /**
     * 根据用户id查询用户的优惠券
     * by杨思源
     */
    @Override
    public List<DiscountCoupon> selectCoupon(WxUser wxUser) {
        List<UserCoupon> userCoupons = userCouponMapper.selectByuserid(wxUser);
        //存储用户的优惠券
        List<DiscountCoupon> discountCoupons=new ArrayList<>();
        for (UserCoupon userCoupon : userCoupons) {
            DiscountCoupon discountCoupon=discountCouponMapper.selectDiscountCouponBycouponid(userCoupon);
            discountCoupons.add(discountCoupon);
        }
        return discountCoupons;
    }

}
