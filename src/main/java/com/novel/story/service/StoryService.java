package com.novel.story.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.story.entity.Story;

import java.util.List;

public interface StoryService extends IService<Story> {
    
    /**
     * 查询所有小说
     * @return 小说列表
     */
    List<Story> getAllStories();
} 