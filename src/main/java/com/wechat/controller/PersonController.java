package com.wechat.controller;

import com.wechat.commons.JsonBean;
import com.wechat.domain.model.WxUser;
import com.wechat.service.WxUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 个人中心控制层
 */
@RestController
public class PersonController {
    @Autowired
    WxUserService wxUserService;

    @RequestMapping("showpersoninfo")
    public JsonBean showPersonInfo(HttpSession session){
        WxUser wxUser = (WxUser) session.getAttribute("wxUser");
        if(wxUser!=null){
            System.out.println("showPersonInfo获取到的session数据"+wxUser.toString());
            return new JsonBean(0,wxUser,"success");
        }
        return new JsonBean(-1,null,"session中没有对象");
    }
}
