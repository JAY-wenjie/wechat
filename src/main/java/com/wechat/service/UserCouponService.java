package com.wechat.service;

import com.wechat.domain.model.DiscountCoupon;
import com.wechat.domain.model.ScoreInfo;
import com.wechat.domain.model.WxUser;

import java.util.List;

/**
 * @author:杨思源
 * @Date:
 */
public interface UserCouponService {
    /**
     *用户兑换优惠券业务
     * by杨思源
     */
    boolean addUserCoupon(WxUser wxUser, DiscountCoupon discountCoupon);
}
