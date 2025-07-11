package com.novel.story.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.story.entity.Classify;
import com.novel.story.mapper.ClassifyMapper;
import com.novel.story.service.ClassifyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {
    @Override
    public List<Classify> getAllClassify() {
        QueryWrapper<Classify> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name");
        return list(queryWrapper);
    }
} 