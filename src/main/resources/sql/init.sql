-- 创建数据库
CREATE DATABASE IF NOT EXISTS novel_story DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE novel_story;

-- 创建小说表
CREATE TABLE IF NOT EXISTS `story` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL COMMENT '小说名称',
    `author` varchar(100) NOT NULL COMMENT '作者',
    `description` text COMMENT '描述',
    `sort_order` int(11) DEFAULT 0 COMMENT '排序标识',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='小说表';

-- 创建章节表
CREATE TABLE IF NOT EXISTS `catalog` (
                                         `id` varchar(50) NOT NULL COMMENT '章节ID',
    `title` varchar(255) NOT NULL COMMENT '章节标题',
    `story_id` int(11) NOT NULL COMMENT '小说ID',
    `sort_order` int(11) DEFAULT 0 COMMENT '排序标识',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='章节表';

-- 创建用户表
CREATE TABLE IF NOT EXISTS `users` (
                                       `id` varchar(50) NOT NULL COMMENT '用户ID',
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(100) NOT NULL COMMENT '密码',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
    `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
    `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 创建评论表
CREATE TABLE IF NOT EXISTS `comment` (
                                         `id` varchar(50) NOT NULL COMMENT '评论ID',
    `story_id` int(11) NOT NULL COMMENT '故事ID',
    `user_id` varchar(50) NOT NULL COMMENT '用户ID',
    `content` text NOT NULL COMMENT '评论内容',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- 插入测试数据
INSERT INTO `story` (`id`, `name`, `author`, `description`) VALUES
                                                                (1, '斗破苍穹', '天蚕土豆', '这里是属于斗气的世界，没有花俏艳丽的魔法，有的，仅仅是繁衍到巅峰的斗气！'),
                                                                (2, '武动乾坤', '天蚕土豆', '武之极，破苍穹，动乾坤！'),
                                                                (3, '大主宰', '天蚕土豆', '大千世界，位面交汇，万族林立，群雄荟萃，一位位来自下位面的天之至尊，在这无尽世界，演绎着令人向往的传奇，追求着那主宰之路。');

INSERT INTO `catalog` (`id`, `title`, `story_id`, `sort_order`) VALUES
                                                                    ('c001', '第一章 陨落的天才', 1, 1),
                                                                    ('c002', '第二章 斗气大陆', 1, 2),
                                                                    ('c003', '第三章 药老', 1, 3),
                                                                    ('c004', '第一章 林动', 2, 1),
                                                                    ('c005', '第二章 石符', 2, 2),
                                                                    ('c006', '第一章 牧尘', 3, 1),
                                                                    ('c007', '第二章 灵路', 3, 2);

INSERT INTO `users` (`id`, `username`, `password`, `email`, `phone`, `create_time`, `update_time`) VALUES
                                                                                                       ('u001', 'admin', '123456', 'admin@example.com', '13800138000', '2024-01-01 00:00:00', '2024-01-01 00:00:00'),
                                                                                                       ('u002', 'user1', '123456', 'user1@example.com', '13800138001', '2024-01-01 00:00:00', '2024-01-01 00:00:00'),
                                                                                                       ('u003', 'user2', '123456', 'user2@example.com', '13800138002', '2024-01-01 00:00:00', '2024-01-01 00:00:00');

INSERT INTO `comment` (`id`, `story_id`, `user_id`, `content`) VALUES
                                                                   ('com001', 1, 'u001', '这本书写得很好，情节很吸引人！'),
                                                                   ('com002', 1, 'u002', '主角的成长历程很励志'),
                                                                   ('com003', 2, 'u001', '武动乾坤也很不错'),
                                                                   ('com004', 3, 'u003', '大主宰的世界观很宏大');
                                                                   CREATE TABLE IF NOT EXISTS `classify` (
  `id` VARCHAR(50) NOT NULL COMMENT '分类ID',
  `name` VARCHAR(100) NOT NULL COMMENT '分类名称',
  `story_id` INT DEFAULT NULL COMMENT '关联小说ID（可选）',
  `story_name` VARCHAR(255) DEFAULT NULL COMMENT '关联小说名称（可选）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='小说分类表';
INSERT INTO `classify` (`id`, `name`) VALUES
('c1', '玄幻'),
('c2', '奇幻'),
('c3', '武侠'),
('c4', '仙侠'),
('c5', '都市'),
('c6', '历史'),
('c7', '科幻'),
('c8', '悬疑'),
('c9', '轻小说'),
('c10', '短篇');


CREATE TABLE IF NOT EXISTS `article` (
                                         `id` VARCHAR(50) NOT NULL COMMENT '文章ID',
    `catalog_id` VARCHAR(50) NOT NULL COMMENT '章节ID',
    `context` TEXT NOT NULL COMMENT '小说内容', -- TEXT 可存放最大65535字节，足够1000字以上
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='小说内容表';