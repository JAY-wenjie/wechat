package com.wechat.domain.model;

public class Collector_Table {
    private Integer id;

    /**
    * spuid
    */
    private Integer poductSpuId;

    /**
    * 收藏时价钱
    */
    private Integer price;

    /**
    * 用户id
    */
    private Integer wxUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoductSpuId() {
        return poductSpuId;
    }

    public void setPoductSpuId(Integer poductSpuId) {
        this.poductSpuId = poductSpuId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }
}