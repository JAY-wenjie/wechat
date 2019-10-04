package com.wechat.service;

import com.wechat.domain.model.DiscountCoupon;

import java.util.List;

public interface DiscountCouponService {
    /**
     * 查询所有的优惠券
     * by杨思源
     */
    List<DiscountCoupon> selectAll();
}
