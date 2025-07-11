package com.novel.story.controller;

import com.novel.story.entity.Comment;
import com.novel.story.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "评论管理")
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @ApiOperation("用户评论小说")
    @PostMapping("/add")
    public Map<String, Object> addComment(@RequestBody Comment comment) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (comment.getStoryId() == null || comment.getUserId() == null || comment.getContent() == null) {
                result.put("code", 400);
                result.put("message", "参数不完整");
                result.put("data", null);
                return result;
            }
            
            boolean success = commentService.addComment(comment);
            if (success) {
                result.put("code", 200);
                result.put("message", "评论成功");
                result.put("data", comment);
            } else {
                result.put("code", 500);
                result.put("message", "评论失败");
                result.put("data", null);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "评论失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }
    
    @ApiOperation("根据小说ID查询评论")
    @GetMapping("/list/{storyId}")
    public Map<String, Object> getCommentsByStoryId(
            @ApiParam(value = "小说ID", required = true) 
            @PathVariable String storyId) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Comment> comments = commentService.getCommentsByStoryId(storyId);
            result.put("code", 200);
            result.put("message", "查询成功");
            result.put("data", comments);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "查询失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }
    
    @ApiOperation("用户删除自己的评论")
    @DeleteMapping("/delete/{commentId}")
    public Map<String, Object> deleteCommentByUser(
            @ApiParam(value = "评论ID", required = true) 
            @PathVariable String commentId,
            @ApiParam(value = "用户ID", required = true) 
            @RequestParam String userId) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = commentService.deleteCommentByUser(commentId, userId);
            if (success) {
                result.put("code", 200);
                result.put("message", "删除成功");
                result.put("data", null);
            } else {
                result.put("code", 400);
                result.put("message", "删除失败：评论不存在或无权限删除");
                result.put("data", null);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", "删除失败: " + e.getMessage());
            result.put("data", null);
        }
        return result;
    }
} 