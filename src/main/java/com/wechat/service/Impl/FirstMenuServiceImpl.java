package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.FirstMenuMapper;
import com.wechat.service.FirstMenuService;

import java.util.List;
import java.util.Map;

@Service
public class FirstMenuServiceImpl implements FirstMenuService{

    @Resource
    private FirstMenuMapper firstMenuMapper;

    @Override
    public List<Map<String, Object>> selectAllMenu() {
        return firstMenuMapper.selectAllMenu();
    }
}
