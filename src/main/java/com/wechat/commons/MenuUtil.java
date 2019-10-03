package com.wechat.commons;


import org.json.JSONArray;
import org.json.JSONObject;


public class MenuUtil {

    public static void main(String[] args) {
        String accessToken = Constant.getAccess_token();
        JSONObject jsonObject = null;
        System.out.println(accessToken);
       String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;

       JSONObject big = new JSONObject();

       JSONArray button =new JSONArray();

       JSONObject menua = new JSONObject();

       menua.put("name","首页");
       menua.put("type","view");
       menua.put("url","http://5k9if5r.hn3.mofasuidao.cn/app/index.html");

        JSONObject menub = new JSONObject();
        menub.put("name","购物车");
        menub.put("type","view");
        menub.put("url","http://5k9if5r.hn3.mofasuidao.cn/app/shopcar.html");
       JSONObject menuc = new JSONObject();
        menuc.put("name","个人中心");
        menuc.put("type","view");
        menuc.put("url","http://5k9if5r.hn3.mofasuidao.cn/app/pcenter.html");

        button.put(menua);
        button.put(menub);
        button.put(menuc);
        big.put("button",button);
        jsonObject = HttpClientUtil.doPost(url,big.toString());
        System.out.println(big.toString());
        System.out.println(jsonObject.toString());
    }
}
