package com.novel.story.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.story.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    
    /**
     * 添加评论
     * @param comment 评论信息
     * @return 是否成功
     */
    boolean addComment(Comment comment);
    
    /**
     * 根据小说ID查询评论
     * @param storyId 小说ID
     * @return 评论列表
     */
    List<Comment> getCommentsByStoryId(String storyId);
    
    /**
     * 用户删除自己的评论
     * @param commentId 评论ID
     * @param userId 用户ID
     * @return 是否成功
     */
    boolean deleteCommentByUser(String commentId, String userId);
} 