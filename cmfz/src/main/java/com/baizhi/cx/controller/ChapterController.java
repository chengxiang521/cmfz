package com.baizhi.cx.controller;

import com.baizhi.cx.entity.Chapter;
import com.baizhi.cx.service.ChapterService;
import com.baizhi.cx.util.UploadFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("chapt")
public class ChapterController {
    @Resource(name = "chapterServiceImpl")
    ChapterService chapterService;

    @RequestMapping("add")
    @ResponseBody
    public void getAlbumID(Chapter ch, HttpSession session, MultipartFile srcpath) throws Exception {
        String pathcx=UploadFile.getAlbumID(session, srcpath);
        ch.setChpath(pathcx);
        ch.setSize(""+(srcpath.getSize()/1024+1));
        try {
            MP3File f = (MP3File) AudioFileIO.read(new File("src/main/webapp/upload/"+pathcx));
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            ch.setDuration(""+audioHeader.getTrackLength());
        } catch(Exception e) {
            e.printStackTrace();
        }
        chapterService.addChapter(ch);
    }
    @RequestMapping("down")
    public void download(String title,String name, HttpSession session, HttpServletResponse response) throws IOException {
        UploadFile.download(title,name,session,response);
    }

}
