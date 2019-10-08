package com.wechat.domain.model;

import javax.persistence.Id;

public class ProductSku {
    /**
    * 商品id
    */
    @Id
    private Integer id;

    /**
    * spu  id
    */
    private Integer productSpuId;

    /**
    * 商品原始进货价格
    */
    private Integer price;

    /**
    * 销售价格
    */
    private Integer salePrice;

    /**
    * 活动价格
    */
    private Integer activePrice;

    /**
    * 状态：-1下架：0上架：1折扣
    */
    private String status;

    /**
    * 颜色
    */
    private String color;

    /**
    * sku产品展示缩略图
    */
    private String skuImg;

    /**
    * 库存数量
    */
    private Integer amount;
 private  PoductSpu poductSpu;

    public PoductSpu getPoductSpu() {
        return poductSpu;
    }

    public void setPoductSpu(PoductSpu poductSpu) {
        this.poductSpu = poductSpu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getActivePrice() {
        return activePrice;
    }

    public void setActivePrice(Integer activePrice) {
        this.activePrice = activePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}