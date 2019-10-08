package com.wechat.domain.mapper;

import com.wechat.domain.model.PcaAreas;

public interface PcaAreasMapper {
    int deleteByPrimaryKey(String areaId);

    int insert(PcaAreas record);

    int insertSelective(PcaAreas record);

    PcaAreas selectByPrimaryKey(String areaId);

    int updateByPrimaryKeySelective(PcaAreas record);

    int updateByPrimaryKey(PcaAreas record);
}