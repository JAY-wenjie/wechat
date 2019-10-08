package com.wechat.domain.model;

import javax.persistence.Id;
import java.util.Date;

public class Order {

    private Integer id;

    private Integer userId;

    private Date creatTime;

    private Date payTime;

    /**
     * 订单完成时间
     */
    private Date endTime;

    /**
     * 订单总金额
     */
    private Integer sumPrice;

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

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Integer sumPrice) {
        this.sumPrice = sumPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", creatTime=" + creatTime +
                ", payTime=" + payTime +
                ", endTime=" + endTime +
                ", sumPrice=" + sumPrice +
                '}';
    }
}