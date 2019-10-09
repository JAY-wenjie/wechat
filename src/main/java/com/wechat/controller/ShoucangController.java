package com.wechat.controller;

import com.wechat.commons.JsonBean;
import com.wechat.domain.model.Shoucang;
import com.wechat.domain.model.WxUser;
import com.wechat.service.ShoucangService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class ShoucangController {
    @Autowired
    ShoucangService shoucangService;

    /**
     * 根据用户id查询用户收藏
     * 敲码者:肖琦
     * @param session
     * @return
     */
    @RequestMapping("selectAllByWxid")
    public JsonBean selectAllByWxid(HttpSession session){
        WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        if (wxUser!=null ) {
            List<Map<String, Object>> list = shoucangService.selectAllByWxid(wxUser.getId());
            return new JsonBean(0,list,"OK");
        }else {
            return new JsonBean(-1,"请登录","NO");
        }
    }

    /**
     * 根据用户id查询当前商品是否收藏
     * 敲码人:肖琦
     *
     * @param session
     * @return
     */
    @RequestMapping("selectShoucangByWxid")
    public JsonBean selectShoucangByWxid(HttpSession session){
        WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        if (wxUser!=null ) {
            Shoucang shoucang = shoucangService.selectShoucangByWxid(wxUser.getId());
            return new JsonBean(0,shoucang,"OK");
        }else {
            return new JsonBean(-1,"未收藏","NO");
        }
    }
}
