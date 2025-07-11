package com.novel.story.controller;

import com.novel.story.entity.Story;
import com.novel.story.service.StoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "小说管理")
@RestController
@RequestMapping("/api/story")
public class StoryController {
    
    @Autowired
    private StoryService storyService;
    
    @ApiOperation("查询所有小说")
    @GetMapping("/list")
    public Map<String, Object> getAllStories() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Story> stories = storyService.getAllStories();
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", stories);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "查询失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }

    @ApiOperation("根据sortOrder降序查询小说（排行榜）")
    @GetMapping("/ranking")
    public Map<String, Object> getRankingStories() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Story> stories = storyService.lambdaQuery().orderByDesc(Story::getSortOrder).list();
            List<Story> collected = stories.stream().limit(6).collect(Collectors.toList()); //排行榜只要前六位
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", collected);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "查询失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }
} 