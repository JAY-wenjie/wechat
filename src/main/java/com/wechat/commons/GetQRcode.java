package com.wechat.commons;

import org.json.JSONObject;

public class GetQRcode {
    public static void main(String[] args) {
       String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+Constant.getAccess_token();
        System.out.println(url);
       /* Map<String,Object> map = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        map3.put("scene_id",1);
        map2.put("scene",map3);
        map.put("action_info",map2);
        map.put("action_name","QR_SCENE");
        map.put("expire_seconds",604800);
        String data = new Gson().toJson(map);*/
        //System.out.println(data);
        String data = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 1}}}";
        JSONObject jsonObject = HttpClientUtil.doPost(url, data);
        System.out.println("jsonobj+++"+jsonObject);
    }
}
