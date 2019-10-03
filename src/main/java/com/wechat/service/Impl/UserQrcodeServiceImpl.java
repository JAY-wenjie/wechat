package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.UserQrcodeMapper;
import com.wechat.service.UserQrcodeService;
@Service
public class UserQrcodeServiceImpl implements UserQrcodeService{

    @Resource
    private UserQrcodeMapper userQrcodeMapper;


}
