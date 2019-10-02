package com.aaa.wechat.domain.model;

public class Brand {
    private Integer id;

    /**
    * 品牌名字
    */
    private String name;

    /**
    * 品牌logo
    */
    private String logo;

    /**
    * 所属国家
    */
    private String country;

    /**
    * 描述
    */
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}