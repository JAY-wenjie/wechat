package com.wechat.service;

import com.wechat.domain.model.ProductCar;
import com.wechat.domain.model.ProductSku;
import com.wechat.domain.model.WxUser;

import java.util.List;

public interface ProductCarService{


    int deleteByPrimaryKey(Integer id);

    int insert(ProductCar record);

    int insertSelective(ProductCar record);

    ProductCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCar record);

    int updateByPrimaryKey(ProductCar record);

    List<ProductCar> listCat(WxUser wxUser);
    List<ProductCar> selectBystatue(Integer id);
    ProductCar selectByskuidNot(Integer id);
}
