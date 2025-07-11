package com.novel.story.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.story.entity.Classify;
import java.util.List;

public interface ClassifyService extends IService<Classify> {
    List<Classify> getAllClassify();
} 