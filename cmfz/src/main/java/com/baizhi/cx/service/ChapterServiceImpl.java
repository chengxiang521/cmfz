package com.baizhi.cx.service;

import com.baizhi.cx.entity.Chapter;
import com.baizhi.cx.mapper.AlbumMapper;
import com.baizhi.cx.mapper.ChapterMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Resource(name = "chapterMapper")
    ChapterMapper chapterMapper;
    @Resource(name = "albumMapper")
    AlbumMapper albumMapper;
    @Override
    public void addChapter(Chapter ch) {
        //专辑的数量加一
        albumMapper.updatealbum(  ch.getAlbumid());
        chapterMapper.addChapter(ch);
    }
}
