package com.wechat.domain.mapper;

import com.wechat.domain.model.UserCoupon;
import com.wechat.domain.model.WxUser;

import java.util.List;

public interface UserCouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCoupon record);

    int insertSelective(UserCoupon record);

    UserCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCoupon record);

    int updateByPrimaryKey(UserCoupon record);

    /**
     * 根据用户id查询用户未使用的优惠券
     * by杨思源
     */
    List<UserCoupon> selectByuserid(WxUser wxUser);
    /**
     * 用户使用优惠券,用户优惠券减少
     * by杨思源
    **/

}