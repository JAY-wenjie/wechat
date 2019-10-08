package com.wechat.service;

import com.wechat.domain.model.ProductSku;

import java.util.List;

public interface ProductSkuService{


    int deleteByPrimaryKey(Integer id);

    int insert(ProductSku record);

    int insertSelective(ProductSku record);

    ProductSku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductSku record);

    int updateByPrimaryKey(ProductSku record);
    List<ProductSku> selectByStatus(int id);
    ProductSku selByAttr(int id);

}
