package com.wechat.domain.mapper;

import com.wechat.domain.model.DiscountCoupon;

import java.util.List;

public interface DiscountCouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiscountCoupon record);

    int insertSelective(DiscountCoupon record);

    DiscountCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiscountCoupon record);

    int updateByPrimaryKey(DiscountCoupon record);

    /**
     * 查询所有的优惠券
     * by杨思源
     */
    List<DiscountCoupon> selectAll();
    /**
     * 用户成功领取优惠券,优惠券库存-1
     */
    int reduceDiscountCoupon(DiscountCoupon discountCoupon);
}