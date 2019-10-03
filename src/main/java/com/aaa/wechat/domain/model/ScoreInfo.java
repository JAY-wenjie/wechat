package com.aaa.wechat.domain.model;

import java.util.Date;

public class ScoreInfo {
    /**
    * 积分详情表id
    */
    private Integer id;

    /**
    * 积分表id
    */
    private Integer scoreId;

    /**
    * 操作详情
    */
    private String detail;

    /**
    * 操作时间
    */
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}