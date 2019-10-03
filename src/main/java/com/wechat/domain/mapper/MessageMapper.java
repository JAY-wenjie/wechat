package com.wechat.domain.mapper;

import com.wechat.domain.model.Message;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MessageMapper extends Mapper<Message> {
    List<Message> selectMessageByGroup(@Param("group") int group);
}