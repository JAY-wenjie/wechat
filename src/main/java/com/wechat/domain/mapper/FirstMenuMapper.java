package com.wechat.domain.mapper;

import com.wechat.domain.model.FirstMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface FirstMenuMapper extends Mapper<FirstMenu> {
    /**
     * 类目分级
     * @return
     */
    List<Map<String,Object>> selectAllMenu();
}