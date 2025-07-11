package com.novel.story.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novel.story.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
} 