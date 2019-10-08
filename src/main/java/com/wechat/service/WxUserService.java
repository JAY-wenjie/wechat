package com.wechat.service;

import com.wechat.domain.model.WxUser;

import java.util.List;

public interface WxUserService {

    WxUser autoInserWxUser(WxUser wxUser);

    List<WxUser> selectFriendById(WxUser wxUser);

    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}


