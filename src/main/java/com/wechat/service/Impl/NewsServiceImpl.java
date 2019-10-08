package com.wechat.service.Impl;

import com.wechat.domain.mapper.NewsMapper;
import com.wechat.domain.model.News;
import com.wechat.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> selectAll() {
        return newsMapper.selectAll();
    }
}
