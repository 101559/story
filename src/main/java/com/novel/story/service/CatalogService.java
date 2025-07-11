package com.novel.story.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.story.entity.Catalog;

import java.util.List;

public interface CatalogService extends IService<Catalog> {
    
    /**
     * 根据小说ID查询章节
     * @param storyId 小说ID
     * @return 章节列表
     */
    List<Catalog> getChaptersByStoryId(String storyId);
} 