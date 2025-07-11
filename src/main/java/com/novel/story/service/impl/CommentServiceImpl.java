package com.novel.story.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.story.entity.Comment;
import com.novel.story.mapper.CommentMapper;
import com.novel.story.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    
    @Override
    public boolean addComment(Comment comment) {
        // 生成评论ID
        comment.setId(UUID.randomUUID().toString().replace("-", ""));
        return save(comment);
    }
    
    @Override
    public List<Comment> getCommentsByStoryId(String storyId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("story_id", storyId);
        queryWrapper.orderByDesc("id");
        return list(queryWrapper);
    }
    
    @Override
    public boolean deleteCommentByUser(String commentId, String userId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", commentId);
        queryWrapper.eq("user_id", userId);
        
        Comment comment = getOne(queryWrapper);
        if (comment != null) {
            return removeById(commentId);
        }
        return false;
    }
} 