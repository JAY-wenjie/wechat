package com.wechat.domain.model;

import java.util.Date;

public class ProductAttr {
    private Integer id;

    private Integer productSkuId;

    private Integer productSpuId;

    private Integer attrValueId;

    private Integer attributeId;

    private Date createTime;

    /**
    * 状态：-1禁用；0启用
    */
    private Integer status;

    private Date updateTime;

    private AttrValue attrValue;

    public AttrValue getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(AttrValue attrValue) {
        this.attrValue = attrValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

    public Integer getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Integer attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}