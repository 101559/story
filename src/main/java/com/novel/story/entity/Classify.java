package com.novel.story.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("classify")
public class Classify {
    private String id;
    private String name;
    private Integer storyId;
    private String storyName;
}
