package com.wechat.domain.model;

import javax.persistence.*;

@Table(name = "second_menu")
public class SecondMenu {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 二级类目名字
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 一级类目id
     */
    @Column(name = "first_menu_id")
    private Integer firstMenuId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取二级类目名字
     *
     * @return name - 二级类目名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置二级类目名字
     *
     * @param name 二级类目名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取一级类目id
     *
     * @return first_menu_id - 一级类目id
     */
    public Integer getFirstMenuId() {
        return firstMenuId;
    }

    /**
     * 设置一级类目id
     *
     * @param firstMenuId 一级类目id
     */
    public void setFirstMenuId(Integer firstMenuId) {
        this.firstMenuId = firstMenuId;
    }
}