package com.novel.story.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.story.entity.Catalog;
import com.novel.story.mapper.CatalogMapper;
import com.novel.story.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl extends ServiceImpl<CatalogMapper, Catalog> implements CatalogService {
    
    @Override
    public List<Catalog> getChaptersByStoryId(String storyId) {
        QueryWrapper<Catalog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("story_id", storyId);
        queryWrapper.orderByAsc("sort_order");
        return list(queryWrapper);
    }
} 