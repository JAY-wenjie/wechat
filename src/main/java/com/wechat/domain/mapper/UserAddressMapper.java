package com.wechat.domain.mapper;

import com.wechat.domain.model.Address;
import com.wechat.domain.model.UserAddress;
import com.wechat.domain.model.WxUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    /**
     * 根据用户id查询地址
     * @param wxUser
     * @return
     */
    List<Map<String,Object>> selectUserAddress(@Param("wxUser") WxUser wxUser);
}