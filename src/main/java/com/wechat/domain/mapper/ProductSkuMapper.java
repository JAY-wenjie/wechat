package com.wechat.domain.mapper;

import com.wechat.domain.model.AttrBean;
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

    /**
     * 根据spuid查询拥有skud的属性
     * @param spuId
     * @return
     */
    List<Map<String,Object>> selectSkuAttrBySpuId(@Param("spuId") int spuId);

    List<AttrBean> selectAttrBySpuId(@Param("spuId") int spuId);

    /**
     * 根据spuid查询拥有skud的颜色属性
     * @param spuId
     * @return
     */
    List<ProductSku> selectColorsBySpuId(@Param("spuId") int spuId);


}