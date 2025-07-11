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
@TableName("comment")
public class Comment {
    private String id; // 评论id
    private String storyId; // 故事id
    private String userId; // 用户id
    private String content; // 评论内容
}
