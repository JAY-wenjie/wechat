package com.wechat.domain.model;

import javax.xml.crypto.Data;
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
    * 操作详情
    */
    private String detail;

    /**
    * 操作时间
    */
    private String time;

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

    public String getTime() {
        return time;
    }

    /**
     * 别再删了
     * @param time
     */
    public void setTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime=sdf.format(time);
        this.time = ctime;
    }

    public ScoreInfo() {
    }

    public ScoreInfo(Integer scoreId, String detail, String time) {
        this.scoreId = scoreId;
        this.detail = detail;
        this.time = time;
    }


    @Override
    public String toString() {
        return "ScoreInfo{" +
                "id=" + id +
                ", scoreId=" + scoreId +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                '}';
    }
}