package com.wechat.service;

import com.wechat.domain.model.AttrValue;
public interface AttrValueService{


    int deleteByPrimaryKey(Integer id);

    int insert(AttrValue record);

    int insertSelective(AttrValue record);

    AttrValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttrValue record);

    int updateByPrimaryKey(AttrValue record);

}
