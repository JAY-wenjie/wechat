package com.wechat.domain.model;

import javax.persistence.*;

@Table(name = "user_qrcode")
public class UserQrcode {
    /**
     * 自增主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 老用户id
     */
    @Column(name = "old_id")
    private Integer oldId;

    /**
     * 新用户id
     */
    @Column(name = "new_id")
    private Integer newId;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取老用户id
     *
     * @return old_id - 老用户id
     */
    public Integer getOldId() {
        return oldId;
    }

    /**
     * 设置老用户id
     *
     * @param oldId 老用户id
     */
    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    /**
     * 获取新用户id
     *
     * @return new_id - 新用户id
     */
    public Integer getNewId() {
        return newId;
    }

    /**
     * 设置新用户id
     *
     * @param newId 新用户id
     */
    public void setNewId(Integer newId) {
        this.newId = newId;
    }
}