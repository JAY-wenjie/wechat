package com.wechat.service;

import com.wechat.domain.model.ProductAttr;
public interface ProductAttrService{


    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttr record);

    int insertSelective(ProductAttr record);

    ProductAttr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductAttr record);

    int updateByPrimaryKey(ProductAttr record);

}
