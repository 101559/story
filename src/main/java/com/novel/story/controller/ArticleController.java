package com.novel.story.controller;

import com.novel.story.entity.Article;
import com.novel.story.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "小说内容")
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation("根据章节ID获取小说内容")
    @GetMapping("/byCatalog")
    public Map<String, Object> getArticleByCatalogId(@RequestParam String catalogId) {
        Map<String, Object> result = new HashMap<>();
        try {
            Article article = articleService.getByCatalogId(catalogId);
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", article);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "查询失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }
} 