package com.novel.story.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *用户表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("users")
public class Users {
    private String id; // 用户ID
    private String username; // 用户名
    private String password; // 密码
    private String email; // 邮箱
    private String phone; // 手机号
    private String createTime; // 创建时间
    private Integer updateTime; // 更新时间

}
