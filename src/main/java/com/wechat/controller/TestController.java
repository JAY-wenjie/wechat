package com.wechat.controller;

import com.wechat.commons.Constant;
import com.wechat.commons.HttpClientUtil;
import com.wechat.commons.WechatRegInfo;
import com.wechat.domain.model.Qrcode;
import com.wechat.domain.model.WxUser;
import com.wechat.service.MessageService;
import com.wechat.service.QrcodeService;
import com.wechat.service.WxUserService;
import com.google.gson.Gson;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TestController {


    @Resource(name = "messageServiceImpl")
    MessageService messageService;
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private QrcodeService qrcodeService;

    /**
     * 与微信握手验证
     *
     * @param wechatRegInfo
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(WechatRegInfo wechatRegInfo) {
        //System.out.println(wechatRegInfo.toString());
        //System.out.println(wechatRegInfo.checkInfo());
        if (wechatRegInfo.checkInfo()) {
            return wechatRegInfo.getEchostr();
        }
        return "";

    }

    /**
     * 消息处理
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String test(HttpServletRequest request, HttpSession session) {

        Element element = null;
        try {
            element = new SAXBuilder().build(request.getInputStream()).getRootElement();
            return messageService.messageFactory(element ,session);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello, world";
    }

    /**
     * 用户网页授权模块
     *
     * @param code
     * @param session
     * @return
     */
    @RequestMapping(value = "code", method = RequestMethod.POST)
    public JSONObject code(String code, HttpSession session) {

        //获取access_token
        System.out.println("用户通过网页授权微信服务器返回的code:" + code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + Constant.APPID + "&secret=" + Constant.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = HttpClientUtil.doGet(url);
        System.out.println("通过获取的code从微信服务器获取的数据");//
        if(session.getAttribute("wxUser")==null){
            //根据通过code获取到的access_token 和 openid获取用户信息
            String url2 = "https://api.weixin.qq.com/sns/userinfo?access_token=" + jsonObject.get("access_token").toString() + "&openid=" + jsonObject.get("openid") + "&lang=zh_CN";
            JSONObject jsonObject1 = HttpClientUtil.doGet(url2);
            System.out.println("用户数据：" + jsonObject1);
            //将获取到的json转换为wxUser对象
            WxUser wxUser = new Gson().fromJson(jsonObject1.toString(), WxUser.class);
            wxUser = wxUserService.autoInserWxUser(wxUser);//用户信息入库
            System.out.println("用户数据入库后返回的用户数据：" + wxUser.toString());
            session.setAttribute("wxUser", wxUser);//将获取的用户id存入session
        }

        return null;
    }

    /**
     * js-sdk用户转发模块
     *
     * @param url
     * @return
     */
    @RequestMapping(value = "config", method = RequestMethod.POST)
    public Map<String, Object> getJsaSdkConfig(String url, HttpSession session) {
        WxUser wxUser = (WxUser) session.getAttribute("wxUser");//从session中获取wxUser
        System.out.println("config获取session中的wxUser值：" + wxUser.toString());
        Qrcode qrcode = qrcodeService.getQrcode(wxUser);
        Map<String, Object> data = Constant.getConfig(url);

        Map<String, String> appMsg = new HashMap<>();
        appMsg.put("title", "越扫越帅，越扫越美");// 分享标题
        appMsg.put("desc", "想得美");// 分享描述
        appMsg.put("link", "http://5k9if5r.hn3.mofasuidao.cn/app/sweep_code.html?tacket=" + qrcode.getTicket());// 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
        appMsg.put("imgUrl", "http://5k9if5r.hn3.mofasuidao.cn/app/images/timg.jpg");// 分享图标
        Map<String, String> timeLine = new HashMap<>();
        timeLine.put("title", "越扫越帅，越扫越美");// 分享标题
        timeLine.put("link", "http://5k9if5r.hn3.mofasuidao.cn/app/sweep_code.html?tacket=" + qrcode.getTicket());// 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
        timeLine.put("imgUrl", "http://5k9if5r.hn3.mofasuidao.cn/app/images/timg.jpg");// 分享图标
        data.put("appMsg", appMsg);
        data.put("timeLine", timeLine);
        //dataAll.put("timeLine",timeLine);
        //PageHelper.startPage(2,2);
        List<WxUser> wxUserList = wxUserService.selectFriendById(wxUser);
        System.out.println(wxUserList.toString());
        data.put("wxUserlist",wxUserList);
        data.put("nowUser",wxUser);
        System.out.println("授权data：" + data.toString());
        return data;
    }

    @RequestMapping(value = "myfriend", method = RequestMethod.POST)
    public List<WxUser> getMyfriend(WxUser wxUser) {
        System.out.println("获取邀请人数传进来的uxUser:"+wxUser.toString());
        List<WxUser> wxUserList = wxUserService.selectFriendById(wxUser);
        System.out.println(wxUserList.toString());
        return wxUserList;
    }


}
