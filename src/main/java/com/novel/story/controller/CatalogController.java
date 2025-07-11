package com.novel.story.controller;

import com.novel.story.entity.Catalog;
import com.novel.story.entity.Story;
import com.novel.story.service.CatalogService;
import com.novel.story.service.StoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "章节管理")
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private StoryService storyService;
    
    @ApiOperation("根据小说ID查询章节")
    @GetMapping("/chapters/{storyId}")
    public Map<String, Object> getChaptersByStoryId(
            @ApiParam(value = "小说ID", required = true) 
            @PathVariable String storyId) {
        Map<String, Object> result = new HashMap<>();
        try {
            Story story = storyService.getById(storyId);
            story.setSortOrder(story.getSortOrder()+1);
            boolean b = storyService.updateById(story);
            System.out.println(b);
            List<Catalog> chapters = catalogService.getChaptersByStoryId(storyId);
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", chapters);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "查询失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }
} 