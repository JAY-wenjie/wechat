package com.wechat.service.Impl;

import com.wechat.commons.Constant;
import com.wechat.commons.HttpClientUtil;
import com.wechat.domain.mapper.UserQrcodeMapper;
import com.wechat.domain.mapper.WxUserMapper;
import com.wechat.domain.model.Message;
import com.wechat.domain.model.UserQrcode;
import com.wechat.domain.model.WxUser;
import com.google.gson.Gson;
import org.jdom2.CDATA;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import com.wechat.domain.mapper.MessageMapper;
import com.wechat.service.MessageService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private WxUserMapper wxUserMapper;

    @Autowired
    private UserQrcodeMapper userQrcodeMapper;

    @Override
    public String messageFactory(Element element, HttpSession session) {
        String xml = "";
        //参数	描述
        //开发者微信号
        String toUserName = element.getChildText("ToUserName");
        //发送方帐号（一个OpenID）
        String fromUserName = element.getChildText("FromUserName");
        //消息创建时间 （整型）
        String createTime = element.getChildText("CreateTime");
        //消息类型，文本为text
        String msgType = element.getChildText("MsgType");
        //	文本消息内容
        String content = element.getChildText("Content");
        //消息id，64位整型
        String msgId = element.getChildText("MsgId");
        WxUser dwxUser = new WxUser();
        dwxUser.setOpenid(fromUserName);
        dwxUser = wxUserMapper.selectByPrimaryKey(dwxUser.getOpenid());
        if (msgType.equals("event")) {
            System.out.println("进入事件");
            xml = evenMsg(element,dwxUser);
        } else if (msgType.equals("text")) {
            xml = "<xml>\n" +
                    "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                    "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                    "  <CreateTime>12345678</CreateTime>\n" +
                    "  <MsgType><![CDATA[text]]></MsgType>\n" +
                    "  <Content><![CDATA[AI小李正在响应...]]></Content>\n" +
                    "</xml>";
            System.out.println("文本消息");

        } else if (msgType.equals("image")) {
            System.out.println("图片消息");
        } else if (msgType.equals("voice")) {
            System.out.println("语音消息");
        } else if (msgType.equals("video")) {
            System.out.println("视频消息");
        }
        session.setAttribute("wxUser",dwxUser);
        //System.out.println(xml);
        return xml;
    }

    private String evenMsg( Element element,WxUser dwxUser) {
        String event = element.getChildText("Event");

        List<Message> messageList = messageMapper.selectMessageByGroup(0);
        WxUser wx_user = new WxUser();
        //开发者微信号
        String toUserName = element.getChildText("ToUserName");
        //发送方帐号（一个OpenID）
        String fromUserName = element.getChildText("FromUserName");
        String xml = "";
        //当消息为事件类型消息时，有值 值为subscribe为关注事件
        if (event.equals("subscribe")) {
            System.out.println("进入关注事件");
            //获取二维码上的场景值
            String eventKey = element.getChildText("EventKey");
            String ticket = element.getChildText("Ticket");

            String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + Constant.getAccess_token() + "&openid=" + element.getChildText("FromUserName") + "&lang=zh_CN";
            JSONObject jsonObject = HttpClientUtil.doGet(url);
            Gson gson = new Gson();
            wx_user = gson.fromJson(jsonObject.toString(), WxUser.class);
            wx_user.setSubscribetime(new Date(System.currentTimeMillis()));
            System.out.println(wx_user.getClass() + "+++++" + wx_user.toString());
            //添加或更新用户

            if (dwxUser==null) {
                String[] split = eventKey.split("_");
                String scene_id = "";
                System.out.println("====="+eventKey);
                //如果是扫码关注的新用户则进入
                System.out.println("增加开始");
                int result = wxUserMapper.insert(wx_user);
                if(split.length>1){
                    scene_id = split[1];
                    int old_id = Integer.parseInt(scene_id);
                    if(old_id!=wx_user.getId()){
                        //实例化新旧用户邀请中间表
                        UserQrcode userQrcode = new UserQrcode();
                        userQrcode.setOldId(old_id);
                        userQrcode.setNewId(wx_user.getId());
                        System.out.println("老用户id="+old_id+"新用户id="+wx_user.getId()+"绑定成功++++++++++++++++++++++++++++++");
                        //用户与扫其推广二维码关注的用户绑定
                        userQrcodeMapper.insertSelective(userQrcode);
                    }else {
                        System.out.println("不能自己邀请自己");
                    }
                }
            } else {
                System.out.println("更新开始");
                int result = wxUserMapper.updateByPrimaryKeySelective(wx_user);
                System.out.println("更新成功：影响行数" + result);
                wx_user.setId(dwxUser.getId());
            }
            System.out.println("最新的用户数据"+wx_user.toString());
            xml = creatResultXml(messageList, fromUserName, toUserName, "news",eventKey,ticket);
            dwxUser = wx_user;
        } else if(event.equals("unsubscribe")) {
            wx_user.setOpenid(fromUserName);
            wx_user.setSubscribe(0);
            int result = wxUserMapper.updateByPrimaryKeySelective(wx_user);
            System.out.println(wx_user.getOpenid() + "取消关注");
        }
        return xml;
    }

    public String creatResultXml(List<Message> messageList, String fromUserName, String toUserName, String msgType,String eventKey,String ticket ) {

        //创建xml节点
        Element xml = new Element("xml");
        xml.addContent(new Element("ToUserName").addContent(new CDATA(fromUserName)));
        xml.addContent(new Element("FromUserName").addContent(new CDATA(toUserName)));
        xml.addContent(new Element("CreateTime").addContent(new CDATA(String.valueOf(System.currentTimeMillis()))));
        xml.addContent(new Element("MsgType").addContent(new CDATA(msgType)));
        xml.addContent(new Element("ArticleCount").addContent(new CDATA(String.valueOf(messageList.size()))));
        Element articles = new Element("Articles");

        for (Message message : messageList) {

            Element item = new Element("item");
            item.addContent(new Element("Title").addContent(new CDATA(message.getTitle())));
            item.addContent(new Element("Description").addContent(new CDATA(message.getDescription())));
            item.addContent(new Element("PicUrl").addContent(new CDATA(message.getPicurl())));
            try {
                String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+Constant.APPID+"&redirect_uri="+ URLEncoder.encode(message.getUrl(),"utf-8")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
                item.addContent(new Element("Url").addContent(new CDATA(url)));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            articles.addContent(item);
        }
        xml.addContent(articles);
        Format format = Format.getCompactFormat();
        format.setEncoding("utf-8");
        XMLOutputter xmlOutputter = new XMLOutputter();
        return xmlOutputter.outputString(xml);
    }
}
