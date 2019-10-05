package com.wechat.commons;


import org.jdom2.CDATA;
import org.jdom2.Element;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 生成菜单
 */
public class MenuUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("网页授权");
        String accessToken = Constant.getAccess_token();
        JSONObject jsonObject = null;
        System.out.println(accessToken);
       String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;

       JSONObject big = new JSONObject();

       JSONArray button =new JSONArray();

       JSONObject menua = new JSONObject();
       String reUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Constant.APPID+"&redirect_uri="+ URLEncoder.encode("http://5k9if5r.hn3.mofasuidao.cn/app/index.html","utf-8")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

       menua.put("name","首页");
       menua.put("type","view");
       menua.put("url",reUrl);
        reUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Constant.APPID+"&redirect_uri="+ URLEncoder.encode("http://5k9if5r.hn3.mofasuidao.cn/app/shopcar.html","utf-8")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

        JSONObject menub = new JSONObject();
        menub.put("name","购物车");
        menub.put("type","view");
        menub.put("url",reUrl);
       JSONObject menuc = new JSONObject();

        reUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Constant.APPID+"&redirect_uri="+ URLEncoder.encode("http://5k9if5r.hn3.mofasuidao.cn/app/pcenter.html","utf-8")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

        menuc.put("name","个人中心");
        menuc.put("type","view");
        menuc.put("url",reUrl);

        button.put(menua);
        button.put(menub);
        button.put(menuc);
        big.put("button",button);
        jsonObject = HttpClientUtil.doPost(url,big.toString());
        System.out.println(big.toString());
        System.out.println(jsonObject.toString());
    }
}
