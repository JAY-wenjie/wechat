package com.wechat.service;

import com.wechat.domain.model.Shoucang;
public interface ShoucangService{


    int deleteByPrimaryKey(Integer id);

    int insert(Shoucang record);

    int insertSelective(Shoucang record);

    Shoucang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shoucang record);

    int updateByPrimaryKey(Shoucang record);

}
