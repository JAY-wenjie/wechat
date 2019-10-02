package com.aaa.wechat.controller;

import com.aaa.wechat.commons.JsonBean;
import com.aaa.wechat.domain.mapper.SysMenuMapper;
import com.aaa.wechat.domain.model.SysMenu;
import com.aaa.wechat.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping("index")
    public JsonBean index() {
        List<SysMenu> sysMenuList = sysMenuService.selectAllMenus();
       JsonBean jsonBean =  new JsonBean(0,sysMenuList,"success");
        return jsonBean;
    }

}
