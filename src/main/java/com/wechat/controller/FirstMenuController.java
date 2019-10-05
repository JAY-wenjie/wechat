package com.wechat.controller;



import com.wechat.commons.JsonBean;
import com.wechat.service.FirstMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstMenuController {
    @Autowired
    FirstMenuService firstMenuService;

    /**
     * 三级类目
     * @return
     */
    @RequestMapping("selectAllMenu")
    public JsonBean selectAllMenu(){
        System.out.println(firstMenuService.selectAllMenu());
        return new JsonBean(0,firstMenuService.selectAllMenu(),"类目");
    }
}
