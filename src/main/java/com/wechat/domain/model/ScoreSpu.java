package com.wechat.domain.model;

import java.util.Date;

public class ScoreSpu {
    /**
    * 积分商品表主键
    */
    private Integer id;

    /**
    * 商品名
    */
    private String productName;

    /**
    * 状态:0未上架,1已上架
    */
    private Integer status;

    /**
    * 创建日期
    */
    private Date createTime;

    /**
    * 更新日期
    */
    private Date updateTime;

    /**
    * 商品描述
    */
    private String describe;

    /**
    * 生产国家
    */
    private String country;

    /**
    * 图片地址
    */
    private String productSpuImg;

    /**
    * 商品价格
    */
    private Integer price;

    /**
    * 兑换所需积分
    */
    private Integer socre;

    /**
    * 评价分数
    */
    private Integer comment;

    /**
    * 商品库存
    */
    private Integer sku;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProductSpuImg() {
        return productSpuImg;
    }

    public void setProductSpuImg(String productSpuImg) {
        this.productSpuImg = productSpuImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSocre() {
        return socre;
    }

    public void setSocre(Integer socre) {
        this.socre = socre;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }
}