package com.novel.story.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.story.entity.Story;
import com.novel.story.mapper.StoryMapper;
import com.novel.story.service.StoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl extends ServiceImpl<StoryMapper, Story> implements StoryService {
    
    @Override
    public List<Story> getAllStories() {
        QueryWrapper<Story> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return list(queryWrapper);
    }
} 