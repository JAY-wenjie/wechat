package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.model.AttrValue;
import com.wechat.domain.mapper.AttrValueMapper;
import com.wechat.service.AttrValueService;
@Service
public class AttrValueServiceImpl implements AttrValueService{

    @Resource
    private AttrValueMapper attrValueMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attrValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AttrValue record) {
        return attrValueMapper.insert(record);
    }

    @Override
    public int insertSelective(AttrValue record) {
        return attrValueMapper.insertSelective(record);
    }

    @Override
    public AttrValue selectByPrimaryKey(Integer id) {
        return attrValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AttrValue record) {
        return attrValueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AttrValue record) {
        return attrValueMapper.updateByPrimaryKey(record);
    }

}
