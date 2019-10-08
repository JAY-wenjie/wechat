package com.wechat.domain.model;

public class UserAddress {
    private Integer id;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 地址id
    */
    private Integer adressId;

    /**
    * 状态:0启用，-1禁用（删除状态）
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

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}