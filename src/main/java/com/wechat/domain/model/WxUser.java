package com.wechat.domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WxUser {
    private Integer id;

    /**
     * 用户openid，当前公众号用户唯一标识
     */
    private String openid;

    /**
     * 关注状态，0取消，1订阅
     */
    private Integer subscribe;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别，1是男，2是女，0是未知
     */
    private Integer sex;

    /**
     * 城市
     */
    private String city;


    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 语言
     */
    private String language;

    /**
     * 头像地址
     */
    private String headimgurl;

    /**
     * 关注时间
     */
    private String subscribetime;

    /**
     * 多个公众号用户唯一标识
     */
    private String unionid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 分组
     */
    private String groupid;

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

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }


    public String getSubscribetime() {
        return subscribetime;
    }

    public void setSubscribetime(Date subscribetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(subscribetime);
        this.subscribetime = createTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", subscribe=" + subscribe +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", language='" + language + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", subscribetime=" + subscribetime +
                ", unionid='" + unionid + '\'' +
                ", remark='" + remark + '\'' +
                ", groupid='" + groupid + '\'' +
                '}';
    }
}