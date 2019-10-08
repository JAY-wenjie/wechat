package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.model.PoductSpu;
import com.wechat.domain.mapper.PoductSpuMapper;
import com.wechat.service.PoductSpuService;

import java.util.List;

@Service
public class PoductSpuServiceImpl implements PoductSpuService{

    @Resource
    private PoductSpuMapper poductSpuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return poductSpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PoductSpu record) {
        return poductSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(PoductSpu record) {
        return poductSpuMapper.insertSelective(record);
    }

    @Override
    public PoductSpu selectByPrimaryKey(Integer id) {
        return poductSpuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PoductSpu record) {
        return poductSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PoductSpu record) {
        return poductSpuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PoductSpu> selectAllProductSpu() {
        return poductSpuMapper.selectAllProductSpu();
    }

}
