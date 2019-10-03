package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.MessageGroupMapper;
import com.wechat.service.MessageGroupService;
@Service
public class MessageGroupServiceImpl implements MessageGroupService{

    @Resource
    private MessageGroupMapper messageGroupMapper;

}
