package com.wechat.domain.model;

import java.util.List;

public class ProductCar {
    /**
    * 购物车id
    */
    private Integer id;

    /**
    * 商品id
    */
    private Integer productSkuId;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 商品数量
    */
    private Integer productSkuNum;

    /**
    * 状态  -1:未选中 0：选中
    */
    private Integer statue;
    List<ProductSku> listSku;

    public List<ProductSku> getListSku() {
        return listSku;
    }

    public void setListSku(List<ProductSku> listSku) {
        this.listSku = listSku;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductSkuNum() {
        return productSkuNum;
    }

    public void setProductSkuNum(Integer productSkuNum) {
        this.productSkuNum = productSkuNum;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }
}