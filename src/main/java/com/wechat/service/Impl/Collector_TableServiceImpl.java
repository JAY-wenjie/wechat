package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.model.Collector_Table;
import com.wechat.domain.mapper.Collector_TableMapper;
import com.wechat.service.Collector_TableService;
@Service
public class Collector_TableServiceImpl implements Collector_TableService{

    @Resource
    private Collector_TableMapper collector_TableMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return collector_TableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Collector_Table record) {
        return collector_TableMapper.insert(record);
    }

    @Override
    public int insertSelective(Collector_Table record) {
        return collector_TableMapper.insertSelective(record);
    }

    @Override
    public Collector_Table selectByPrimaryKey(Integer id) {
        return collector_TableMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Collector_Table record) {
        return collector_TableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Collector_Table record) {
        return collector_TableMapper.updateByPrimaryKey(record);
    }

}
