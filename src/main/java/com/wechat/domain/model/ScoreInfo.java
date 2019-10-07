package com.wechat.domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreInfo {
    /**
     * 积分详情表id
     */
    private Integer id;

    /**
     * 用户积分表id
     */
    private Integer scoreId;

    /**
     * 兑换的商品id
     */
    private Integer spuId;

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

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
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
// public String getTime() {
    //     return time;
    // }
    //
    // public void setTime(Date time) {
    //     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //     String ctime = sdf.format(time);
    //     this.time = ctime;
    // }

    public ScoreInfo() {
    }

    public ScoreInfo(Integer scoreId, String detail, Date time) {
        this.scoreId = scoreId;
        this.detail = detail;
        this.time = time;
    }

    public ScoreInfo(Integer id, Integer scoreId, Integer spuId, String detail, Date time) {
        this.id = id;
        this.scoreId = scoreId;
        this.spuId = spuId;
        this.detail = detail;
        this.time = time;
    }

    public ScoreInfo(Integer scoreId, Integer spuId, String detail, Date time) {
        this.scoreId = scoreId;
        this.spuId = spuId;
        this.detail = detail;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ScoreInfo{" +
                "id=" + id +
                ", scoreId=" + scoreId +
                ", spuId=" + spuId +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                '}';
    }
}