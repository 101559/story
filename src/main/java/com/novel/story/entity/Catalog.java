package com.novel.story.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 目录  包含小说章节标题
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("catalog")
public class Catalog {
    private String id; //章节ID
    private String title; //章节标题
    private String storyId; //小说ID
    private Integer sortOrder; //  排序标识
}
