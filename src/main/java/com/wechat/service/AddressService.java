package com.wechat.service;

import com.wechat.domain.model.Address;
import com.wechat.domain.model.PcaProvinces;
import com.wechat.domain.model.UserAddress;

import java.util.List;

public interface AddressService{


    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<PcaProvinces> selectAllProvinces();
}
