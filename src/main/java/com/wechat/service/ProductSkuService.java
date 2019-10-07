package com.wechat.service;

import com.wechat.domain.model.ProductSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductSkuService{


    int deleteByPrimaryKey(Integer id);

    int insert(ProductSku record);

    int insertSelective(ProductSku record);

    ProductSku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductSku record);

    int updateByPrimaryKey(ProductSku record);

    List<ProductSku> selectByStatus(int id);

    Map<String,Object> selectSkuBySpuId(int spuId);

    List<Map<String,Object>> selectSkuImgById(@Param("skuId") int skuId);


}
