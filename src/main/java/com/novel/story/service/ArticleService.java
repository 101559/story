package com.novel.story.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.story.entity.Article;

public interface ArticleService extends IService<Article> {
    Article getByCatalogId(String catalogId);
} 