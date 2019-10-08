package com.wechat.domain.mapper;

import com.wechat.domain.model.ProductSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductSkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductSku record);

    int insertSelective(ProductSku record);

    ProductSku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductSku record);

    int updateByPrimaryKey(ProductSku record);

    List<ProductSku> selectByStatus(int id);

    Map<String,Object> selectSkuBySpuId(@Param("spuId") int spuId);

    List<Map<String,Object>> selectSkuImgById(@Param("skuId") int skuId);


}