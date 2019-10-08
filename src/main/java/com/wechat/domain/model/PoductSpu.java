package com.wechat.domain.model;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PoductSpu {
    @Id
    private Integer id;

    private String productName;

    /**
    * 折扣值
    */
    private Integer discount;

    private Integer brandId;

    /**
    * 状态：-1 下架；0上架
    */
    private Integer status;

    /**
    * 二级类目id
    */
    private Integer secondMenuId;

    /**
    * 更新修改日期
    */
    private Date updateTime;

    /**
    * 创建日期
    */
    private Date createTime;

    /**
    * 品牌描述
    */
    private String describe;

    /**
    * 所属国家
    */
    private String country;

    /**
    * spu产品展示缩略图
    */
    private String productSpuImg;

    private Map<String,Object> productSku;

    public Map<String, Object> getProductSku() {
        return productSku;
    }

    public void setProductSku(Map<String, Object> productSku) {
        this.productSku = productSku;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSecondMenuId() {
        return secondMenuId;
    }

    public void setSecondMenuId(Integer secondMenuId) {
        this.secondMenuId = secondMenuId;
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
}