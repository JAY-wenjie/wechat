package com.wechat.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface FirstMenuService{
    /**
     * 类目分级
     * @return
     */
    List<Map<String,Object>> selectAllMenu();

}
