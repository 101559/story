package com.novel.story.controller;

import com.novel.story.entity.Classify;
import com.novel.story.entity.Story;
import com.novel.story.service.ClassifyService;
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

@Api(tags = "分类管理")
@RestController
@RequestMapping("/api/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private StoryService storyService;

    @ApiOperation("获取所有分类")
    @GetMapping("/list")
    public Map<String, Object> getAllClassify() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Classify> list = classifyService.getAllClassify();
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", list);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "查询失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }

    @ApiOperation("根据分类ID查询小说")
    @GetMapping("/stories")
    public Map<String, Object> getStoriesByClassifyId(String classifyId) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 查询该分类下所有storyId
            List<Classify> classifyList = classifyService.lambdaQuery().eq(Classify::getId, classifyId).list();
            List<Integer> storyIds = new java.util.ArrayList<>();
            for (Classify c : classifyList) {
                if (c.getStoryId() != null) {
                    storyIds.add(c.getStoryId());
                }
            }
            List<Story> stories;
            if (storyIds.isEmpty()) {
                stories = new java.util.ArrayList<>();
            } else {
                stories = storyService.lambdaQuery().in(Story::getId, storyIds).list();
            }
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
} 