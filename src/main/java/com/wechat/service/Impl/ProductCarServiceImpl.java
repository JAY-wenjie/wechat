package com.wechat.service.Impl;

import com.wechat.domain.model.ProductSku;
import com.wechat.domain.model.WxUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.ProductCarMapper;
import com.wechat.domain.model.ProductCar;
import com.wechat.service.ProductCarService;

import java.util.List;

@Service
public class ProductCarServiceImpl implements ProductCarService{

    @Resource
    private ProductCarMapper productCarMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductCar record) {
        return productCarMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductCar record) {
        return productCarMapper.insertSelective(record);
    }

    @Override
    public ProductCar selectByskuidNot(Integer id) {
        return productCarMapper.selectByskuidNot(id);
    }

    @Override
    public ProductCar selectByPrimaryKey(Integer id) {
        return productCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductCar record) {
        return productCarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductCar record) {
        return productCarMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProductCar> listCat(WxUser wxUser) {
        return productCarMapper.selectCarByskuandSpu(wxUser);
    }

    @Override
    public List<ProductCar> selectBystatue(Integer id) {
        return productCarMapper.selectBystatue(id);
    }
}
