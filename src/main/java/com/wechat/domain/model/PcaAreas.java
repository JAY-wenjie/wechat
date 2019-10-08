package com.wechat.domain.model;

public class PcaAreas {
    /**
    * 区/县id
    */
    private String areaId;

    /**
    * 区/县名称
    */
    private String areaName;

    /**
    * 市id
    */
    private String cityId;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}