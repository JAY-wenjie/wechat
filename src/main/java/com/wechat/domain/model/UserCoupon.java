package com.wechat.domain.model;

/**
 * 用户优惠券表
 *
 * @author:杨思源
 * @Date:
 */
public class UserCoupon {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 状态:0未使用,1已使用
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserCoupon(Integer userId, Integer couponId, Integer status) {
        this.userId = userId;
        this.couponId = couponId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserCoupon{" +
                "id=" + id +
                ", userId=" + userId +
                ", couponId=" + couponId +
                ", status=" + status +
                '}';
    }
}