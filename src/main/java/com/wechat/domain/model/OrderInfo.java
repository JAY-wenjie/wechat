package com.wechat.domain.model;

public class OrderInfo {
    /**
    * 订单状态：-1 未付款；0代发货；1待收货；2待评价；3 发起退款
    */
    private Integer id;

    /**
    * 订单编号
    */
    private Integer orderId;

    /**
    * 商品编号
    */
    private Integer productId;

    /**
    * 支付金额
    */
    private Integer payPrice;

    /**
    * 活动类型
    */
    private String activeType;

    private Integer productNum;

    /**
    * 优惠卷id
    */
    private Integer discountCouponId;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Integer payPrice) {
        this.payPrice = payPrice;
    }

    public String getActiveType() {
        return activeType;
    }

    public void setActiveType(String activeType) {
        this.activeType = activeType;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getDiscountCouponId() {
        return discountCouponId;
    }

    public void setDiscountCouponId(Integer discountCouponId) {
        this.discountCouponId = discountCouponId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}