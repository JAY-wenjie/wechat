package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.ProductAttrMapper;
import com.wechat.domain.model.ProductAttr;
import com.wechat.service.ProductAttrService;
@Service
public class ProductAttrServiceImpl implements ProductAttrService{

    @Resource
    private ProductAttrMapper productAttrMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productAttrMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductAttr record) {
        return productAttrMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductAttr record) {
        return productAttrMapper.insertSelective(record);
    }

    @Override
    public ProductAttr selectByPrimaryKey(Integer id) {
        return productAttrMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductAttr record) {
        return productAttrMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductAttr record) {
        return productAttrMapper.updateByPrimaryKey(record);
    }

}
