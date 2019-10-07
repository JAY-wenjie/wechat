package com.wechat.commons;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
public class Constant {
    //测试号使用
    public static final String APPID = "wx899f93c8b804cc0f";
    public static final String APPSECRET = "2efdca89d87933c25fe64b125d43eda1";
    public static String ACCESS_TOKEN = null;
    public static long ACCESS_TOKEN_TIME = 0L;
    public static String JSAPI_TICKET = null;
    public static long SAPI_TICKET_TIME = 0L;


    public static String getAccess_token() {
        JSONObject jsonObject = null;
        long now = System.currentTimeMillis() / 1000;
        if (ACCESS_TOKEN == null || (now - ACCESS_TOKEN_TIME) >= 7200) {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;
            jsonObject = HttpClientUtil.doGet(url);
            // System.out.println("url"+url);
            // System.out.println(jsonObject.toString());
            ACCESS_TOKEN_TIME = System.currentTimeMillis() / 1000;
            ACCESS_TOKEN = jsonObject.get("access_token").toString();
        }
        return ACCESS_TOKEN;
    }

    /**
     * 获取JSAPI_TICKET
     *
     * @return
     */
    public static String getJsapi_ticket() {
        JSONObject jsonObject = null;
        long now = System.currentTimeMillis() / 1000;
        if (ACCESS_TOKEN == null || (now - SAPI_TICKET_TIME) >= 7200) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + getAccess_token() + "&type=jsapi";
            jsonObject = HttpClientUtil.doGet(url);
            if (jsonObject.get("errcode").equals(0)) {
                JSAPI_TICKET = jsonObject.get("ticket").toString();
                System.out.println("constant中的at"+JSAPI_TICKET);
                SAPI_TICKET_TIME = System.currentTimeMillis() / 1000;
            }
        }

        return JSAPI_TICKET;
    }

    /**
     * JS-SDK的页面需要注入的配置信息
     * @param url
     * @return
     */
    public static Map<String, Object> getConfig(String url) {
        String noncestr = UUID.randomUUID().toString().replaceAll("-", "");
        String jsapi_ticket = getJsapi_ticket();
        System.out.println("getJsapi_ticket:"+getJsapi_ticket());
        long timestamp = System.currentTimeMillis() / 1000l;
        System.out.println("url+++++++"+url);
        String str = "jsapi_ticket="+jsapi_ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
        String signature = WechatRegInfo.getSha1(str);
        Map<String,Object> map = new HashMap<>();
        map.put("appId",APPID);
        map.put("timestamp",String.valueOf(timestamp));
        map.put("nonceStr",noncestr);
        map.put("signature",signature);

        return map;
    }
}
