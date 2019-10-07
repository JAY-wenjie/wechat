package com.wechat.domain.mapper;

import com.wechat.domain.model.PcaProvinces;

import java.util.List;

public interface PcaProvincesMapper {
    int deleteByPrimaryKey(String provinceId);

    int insert(PcaProvinces record);

    int insertSelective(PcaProvinces record);

    PcaProvinces selectByPrimaryKey(String provinceId);

    int updateByPrimaryKeySelective(PcaProvinces record);

    int updateByPrimaryKey(PcaProvinces record);

    List<PcaProvinces> selectAll();
}