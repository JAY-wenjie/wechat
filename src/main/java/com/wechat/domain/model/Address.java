package com.wechat.domain.model;

public class Address {
    private Integer id;

    /**
    * 省
    */
    private String provinces;

    /**
    * 市
    */
    private String cities;

    /**
    * 区
    */
    private String areas;

    /**
    * 详细地址
    */
    private String address;
    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 收货人电话
     */
    private String telephone;


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}