package com.wechat.domain.model;

import javax.persistence.*;

@Table(name = "first_menu")
public class FirstMenu {
    /**
     * 一级类目ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 一级类目名字
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 获取一级类目ID
     *
     * @return id - 一级类目ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置一级类目ID
     *
     * @param id 一级类目ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取一级类目名字
     *
     * @return name - 一级类目名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置一级类目名字
     *
     * @param name 一级类目名字
     */
    public void setName(String name) {
        this.name = name;
    }
}