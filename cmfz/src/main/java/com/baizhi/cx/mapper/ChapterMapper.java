package com.baizhi.cx.mapper;

import com.baizhi.cx.entity.Chapter;
import tk.mybatis.mapper.common.Mapper;

public interface ChapterMapper extends Mapper<Chapter> {
public void addChapter(Chapter c);
}
