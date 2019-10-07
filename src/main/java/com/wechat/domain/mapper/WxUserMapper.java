package com.wechat.domain.mapper;

import com.wechat.domain.model.WxUser;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);

    List<WxUser> selectFriendById(@Param("wxUser") WxUser wxUser);
}