package com.wechat.domain.model;

import java.util.Date;
/**
 * @author:杨思源
 * @Date:
 */
public class DiscountCoupon {
    private Integer id;

    /**
     * 优惠券描述(满多少减多少)
     */
    private String description;

    /**
     * 起始日期
     */
    private Date startTime;

    /**
     * 截止日期
     */
    private Date endTime;

    /**
     * 兑换所需积分
     */
    private Integer payScore;

    /**
     * 抵扣金额
     */
    private Integer discountPrice;

    /**
     * 满多少钱可以使用
     */
    private Integer startPrice;

    /**
     * 优惠券库存数量
     */
    private Integer couponSku;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPayScore() {
        return payScore;
    }

    public void setPayScore(Integer payScore) {
        this.payScore = payScore;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getCouponSku() {
        return couponSku;
    }

    public void setCouponSku(Integer couponSku) {
        this.couponSku = couponSku;
    }

    @Override
    public String toString() {
        return "DiscountCoupon{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", payScore=" + payScore +
                ", discountPrice=" + discountPrice +
                ", startPrice=" + startPrice +
                ", couponSku=" + couponSku +
                '}';
    }
}