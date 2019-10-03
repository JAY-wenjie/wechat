package com.wechat.domain.model;

import javax.persistence.Id;

public class Qrcode {
    private Integer id;

    /**
    * 微信用户的openid
    */
    @Id
    private String openid;

    /**
    * 二维码获取凭证
    */
    private String ticket;

    /**
    * 二维码有效时间单位秒
    */
    private Integer expireSeconds;

    /**
    * 二维码创建时间单位秒
    */
    private Integer createSeconds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public Integer getCreateSeconds() {
        return createSeconds;
    }

    public void setCreateSeconds(Integer createSeconds) {
        this.createSeconds = createSeconds;
    }
}