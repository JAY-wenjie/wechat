package com.wechat.domain.model;

import javax.persistence.*;

@Table(name = "message_group")
public class MessageGroup {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * message主键id
     */
    @Column(name = "m_id")
    private Integer mId;

    /**
     * 所属组（类别）id
     */
    @Column(name = "`group`")
    private Integer group;

    /**
     * 排序字段
     */
    @Column(name = "sort")
    private Integer sort;

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
     * 获取message主键id
     *
     * @return m_id - message主键id
     */
    public Integer getmId() {
        return mId;
    }

    /**
     * 设置message主键id
     *
     * @param mId message主键id
     */
    public void setmId(Integer mId) {
        this.mId = mId;
    }

    /**
     * 获取所属组（类别）id
     *
     * @return group - 所属组（类别）id
     */
    public Integer getGroup() {
        return group;
    }

    /**
     * 设置所属组（类别）id
     *
     * @param group 所属组（类别）id
     */
    public void setGroup(Integer group) {
        this.group = group;
    }

    /**
     * 获取排序字段
     *
     * @return sort - 排序字段
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序字段
     *
     * @param sort 排序字段
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}