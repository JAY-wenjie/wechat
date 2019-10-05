package com.wechat.service.Impl;

import com.wechat.domain.mapper.DiscountCouponMapper;
import com.wechat.domain.model.DiscountCoupon;
import com.wechat.service.DiscountCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCouponServiceImpl implements DiscountCouponService {
    @Autowired
    DiscountCouponMapper discountCouponMapper;

    @Override
    public List<DiscountCoupon> selectAll() {
        List<DiscountCoupon> discountCoupons = discountCouponMapper.selectAll();
        return discountCoupons;
    }
}
