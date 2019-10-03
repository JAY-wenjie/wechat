package com.wechat.domain.model;

import javax.persistence.*;

@Table(name = "message")
public class Message {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 展示图片路径
     */
    @Column(name = "picurl")
    private String picurl;

    /**
     * 点击连接url
     */
    @Column(name = "url")
    private String url;

    /**
     * 状态 -1为禁用 0为启用
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取展示图片路径
     *
     * @return picurl - 展示图片路径
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * 设置展示图片路径
     *
     * @param picurl 展示图片路径
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * 获取点击连接url
     *
     * @return url - 点击连接url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置点击连接url
     *
     * @param url 点击连接url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取状态 -1为禁用 0为启用
     *
     * @return status - 状态 -1为禁用 0为启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 -1为禁用 0为启用
     *
     * @param status 状态 -1为禁用 0为启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}