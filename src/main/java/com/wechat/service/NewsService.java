package com.wechat.service;

import com.wechat.domain.model.News;

import java.util.List;

public interface NewsService {
    /**
     * 查询全部新闻资讯
     * by杨思源
     */
    List<News> selectAll();
}
