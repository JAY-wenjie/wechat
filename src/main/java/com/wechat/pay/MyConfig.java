package com.wechat.pay;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyConfig implements WXPayConfig {
    @Override
    public String getAppID() {
        return "wxc37f01894579f97b";
    }

    @Override
    public String getMchID() {
        return "1519853611";
    }

    @Override
    public String getKey() {
        return "qwertyuiopasdfghjklzxcvbnm123456";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}