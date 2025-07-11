package com.novel.story.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 小说表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("story")
public class Story {
    private Integer id; // 小说id
    private String name;   //  小说名称
    private String author; //  作者
    private String description; //  描述
    private Integer sortOrder; //排行榜排名需要   排序标识

}
