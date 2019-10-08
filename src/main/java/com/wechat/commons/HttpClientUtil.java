package com.wechat.commons;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

/**
 * \
 */
public class HttpClientUtil {
    public static JSONObject doGet(String url){
        JSONObject jsonObject = null;
        //实例化httpget请求
        HttpGet httpGet = new HttpGet(url);
        //创建一个客户端httpclient
        org.apache.http.client.HttpClient httpClient =  new DefaultHttpClient();

        jsonObject = getJsonObject(jsonObject, httpGet, httpClient);
        return jsonObject;
    }
    public static JSONObject doPost(String url,String data){
        JSONObject jsonObject = null;
        HttpPost httpPost = new  HttpPost(url);

        HttpClient httpClient =  new DefaultHttpClient();
        httpPost.setEntity(new StringEntity(data,"utf-8"));
        jsonObject = getJsonObject(jsonObject, httpPost, httpClient);
        return jsonObject;
    }

    private static JSONObject getJsonObject(JSONObject jsonObject, HttpRequestBase httpRequestBase, HttpClient httpClient) {
        try {
            //发送请求
            HttpResponse httpResponse = httpClient.execute(httpRequestBase);

            if(httpResponse.getStatusLine().getStatusCode()==200){
                //转化为字符串
                String str = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
               // System.out.println(str);
                //将字符串转化为json数据
                jsonObject = new JSONObject(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
