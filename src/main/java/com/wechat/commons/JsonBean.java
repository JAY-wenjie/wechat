package com.wechat.commons;

/**
 * @author CHENCHEN
 * @company XJA
 * @create 2019-09-21 14:34
 */
public class JsonBean {
    private int code;

    private Object object;

    private String msg;

    public JsonBean() {
    }

    public JsonBean(int code, Object object, String msg) {
        this.code = code;
        this.object = object;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
