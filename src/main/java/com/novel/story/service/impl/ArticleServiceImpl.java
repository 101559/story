package com.novel.story.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.story.entity.Article;
import com.novel.story.mapper.ArticleMapper;
import com.novel.story.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public Article getByCatalogId(String catalogId) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("catalog_id", catalogId);
        return getOne(queryWrapper);
    }
} 