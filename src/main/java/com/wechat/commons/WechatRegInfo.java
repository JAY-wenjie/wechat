package com.wechat.commons;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 微信验证消息
 */
public class WechatRegInfo {


    private String signature;    //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
    private String timestamp;    //时间戳
    private String nonce;    //随机数
    private String echostr;//	随机字符串
    private final String token = "16";

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    /**
     * 验证
     *
     * @return
     */
    public boolean checkInfo() {
        List<String> strList = new ArrayList<String>();
        strList.add(timestamp);
        strList.add(nonce);
        strList.add(token);
        //排序
        System.out.println("排序前："+strList.toString());
        Collections.sort(strList);
        System.out.println("排序后"+strList.toString());
        String str = "";
        for (int i = 0; i < strList.size(); i++) {
            str+=strList.get(i);
        }
        String shelStr =getSha1(str);

        System.out.println("shelStr="+shelStr);
        System.out.println("signature="+signature);
        if (shelStr.equals(signature)) {
            return true;
        }
        return false;
    }

    public static String getSha1(String str) {

        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }



    @Override
    public String toString() {
        return "checkInfo:{"
                + "signature=" + signature + "\n" +
                "timestamp=" + timestamp + "\n" +
                "nonce=" + nonce + "\n" +
                "echostr=" + echostr + "\n" +
                "}";
    }
}
