package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.model.ProductSku;
import com.wechat.domain.mapper.ProductSkuMapper;
import com.wechat.service.ProductSkuService;

import java.util.List;

@Service
public class ProductSkuServiceImpl implements ProductSkuService{

    @Resource
    private ProductSkuMapper productSkuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productSkuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductSku record) {
        return productSkuMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductSku record) {
        return productSkuMapper.insertSelective(record);
    }

    @Override
    public ProductSku selectByPrimaryKey(Integer id) {
        return productSkuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductSku record) {
        return productSkuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductSku record) {
        return productSkuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProductSku> selectByStatus(int id) {
        return productSkuMapper.selectByStatus(id);
    }

    @Override
    public ProductSku selByAttr(int id) {
        return productSkuMapper.selByAttr(id);
    }
}
