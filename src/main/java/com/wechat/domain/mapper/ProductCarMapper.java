package com.wechat.domain.mapper;

import com.wechat.domain.model.ProductCar;
import com.wechat.domain.model.ProductSku;
import com.wechat.domain.model.WxUser;

import java.util.List;

public interface ProductCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCar record);

    int insertSelective(ProductCar record);

    ProductCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCar record);

    int updateByPrimaryKey(ProductCar record);
    List<ProductCar>selectCarByskuandSpu(WxUser wxUser);
    List<ProductCar> selectBystatue(Integer id);
    ProductCar selectByskuidNot(Integer id);
}