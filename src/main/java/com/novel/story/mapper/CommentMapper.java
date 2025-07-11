package com.novel.story.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novel.story.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
} 