package com.wechat.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.model.Shoucang;
import com.wechat.domain.mapper.ShoucangMapper;
import com.wechat.service.ShoucangService;

import java.util.List;
import java.util.Map;

@Service
public class ShoucangServiceImpl implements ShoucangService{

    @Resource
    private ShoucangMapper shoucangMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return shoucangMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Shoucang record) {
        return shoucangMapper.insert(record);
    }

    @Override
    public int insertSelective(Shoucang record) {
        return shoucangMapper.insertSelective(record);
    }

    @Override
    public Shoucang selectByPrimaryKey(Integer id) {
        return shoucangMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Shoucang record) {
        return shoucangMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Shoucang record) {
        return shoucangMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> selectAllByWxid(int id) {
        return shoucangMapper.selectAllByWxid(id);
    }

    @Override
    public Shoucang selectShoucangByWxid(int id) {
        return shoucangMapper.selectShoucangByWxid(id);
    }

}
