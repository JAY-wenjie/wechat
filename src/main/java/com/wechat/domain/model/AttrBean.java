package com.wechat.domain.model;

import java.util.List;
import java.util.Map;

public class AttrBean {
    private String name;
    private List<Map<String,Object>> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getValueList() {
        return valueList;
    }

    public void setValueList(List<Map<String, Object>> valueList) {
        this.valueList = valueList;
    }
}
