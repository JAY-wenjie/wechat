package com.wechat.domain.model;

import java.util.Date;
/**
 * @author:杨思源
 * @Date:
 */
public class UserScore {
    /**
     * 积分表主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户积分
     */
    private Integer score;

    /**
     * 用户连续签到天数
     */
    private Integer days;

    /**
     * 最后一次签到时间
     */
    private Date lastSign;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getLastSign() {
        return lastSign;
    }

    public void setLastSign(Date lastSign) {
        this.lastSign = lastSign;
    }

    public UserScore() {
    }

    public UserScore(Integer score, Integer days) {
        this.score = score;
        this.days = days;
    }

    public UserScore(Integer userId, Integer days, Date lastSign) {
        this.userId = userId;
        this.days = days;
        this.lastSign = lastSign;
    }


    public UserScore(Integer id, Integer userId, Integer score, Integer days, Date lastSign) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.days = days;
        this.lastSign = lastSign;
    }


    @Override
    public String toString() {
        return "UserScore{" +
                "id=" + id +
                ", userId=" + userId +
                ", score=" + score +
                ", days=" + days +
                ", lastSign=" + lastSign +
                '}';
    }
}