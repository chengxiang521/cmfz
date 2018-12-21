package com.baizhi.cx.controller;

import com.baizhi.cx.entity.Chapter;
import com.baizhi.cx.service.ChapterService;
import com.baizhi.cx.util.UploadFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("chapt")
public class ChapterController {
    @Resource(name = "chapterServiceImpl")
    ChapterService chapterService;

    @RequestMapping("add")
    @ResponseBody
    public void getAlbumID(Chapter ch, HttpSession session, MultipartFile srcpath) throws Exception {
        ch.setChpath(UploadFile.getAlbumID(session, srcpath));
        chapterService.addChapter(ch);
    }
    @RequestMapping("down")
    public void download(String name, HttpSession session, HttpServletResponse response) throws IOException {
        UploadFile.download(name,session,response);
    }

}
