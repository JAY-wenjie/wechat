package com.wechat.service.Impl;

import com.wechat.domain.model.WxUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.model.UserAddress;
import com.wechat.domain.mapper.UserAddressMapper;
import com.wechat.service.UserAddressService;

import java.util.List;
import java.util.Map;

@Service
public class UserAddressServiceImpl implements UserAddressService{

    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserAddress record) {
        return userAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(UserAddress record) {
        return userAddressMapper.insertSelective(record);
    }

    @Override
    public UserAddress selectByPrimaryKey(Integer id) {
        return userAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAddress record) {
        return userAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAddress record) {
        return userAddressMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> selectUserAddress(WxUser wxUser) {
        return userAddressMapper.selectUserAddress(wxUser);
    }

}
