package com.wechat.domain.mapper;

import com.wechat.domain.model.Shoucang;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoucangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shoucang record);

    int insertSelective(Shoucang record);

    Shoucang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shoucang record);

    int updateByPrimaryKey(Shoucang record);

    /**
     * 根据用户id查询用户收藏
     * 敲码人:肖琦
     *
     * @param id
     * @return
     */
    List<Map<String, Object>> selectAllByWxid(@Param("id") int id);

    /**
     * 根据用户id查询当前商品是否收藏
     * 敲码人:肖琦
     *
     * @param id
     * @return
     */
    Shoucang selectShoucangByWxid(@Param("id") int id);
}