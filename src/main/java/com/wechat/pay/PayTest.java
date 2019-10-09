package com.wechat.pay;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class PayTest {
    public static void main(String[] args) {
        WXPay wxPay = new WXPay(new MyConfig());
        Map<String,String> map=new HashMap<>();
        map.put("body", "扫码支付测试");//商品描述
        map.put("out_trade_no", "201910081903");//商户订单号
        map.put("total_fee", "1");//标价金额单位分
        map.put("spbill_create_ip", "123.12.12.123");//终端IP
        map.put("notify_url", "http://www.example.com/wxpay/notify");//通知地址
        map.put("trade_type", "NATIVE");  // 此处指定为扫码支付        data.put("product_id", "12");

        try {
            Map<String, String> stringStringMap = wxPay.unifiedOrder(map);
            System.out.println(stringStringMap.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
