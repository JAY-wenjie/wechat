package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.SecondMenuMapper;
import com.wechat.service.SecondMenuService;
@Service
public class SecondMenuServiceImpl implements SecondMenuService{

    @Resource
    private SecondMenuMapper secondMenuMapper;

}
