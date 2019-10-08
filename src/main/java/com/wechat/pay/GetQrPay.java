package com.wechat.pay;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取微信支付二维码
 */
public class GetQrPay {
    public static void main(String[] args) {
        MyConfig myConfig = new MyConfig();
        WXPay wxPay = new WXPay(myConfig);
        Map<String,String> data = new HashMap<>();
        data.put("body", "腾讯充值中心");
        data.put("out_trade_no", "20191008600089");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        Map<String, String> resp = null;
        try {
            resp = wxPay.unifiedOrder(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resp.toString());

    }



}
