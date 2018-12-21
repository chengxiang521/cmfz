package com.baizhi.cx.controller;

import com.baizhi.cx.entity.Album;
import com.baizhi.cx.service.AlbumService;
import com.baizhi.cx.util.UploadFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Resource(name = "albumServiceImpl")
    AlbumService albumService;

    @RequestMapping("all")
    @ResponseBody
    public List<Album> selectall() {
        List<Album> list = albumService.queryAllcx();
        return list;
    }

    @RequestMapping("one")
    @ResponseBody
    public Album getAlbumID(String id) {
        return albumService.queryByID(id);
    }

    @RequestMapping("add")
    @ResponseBody
    public void getAlbumID(Album a, HttpSession session, MultipartFile srcpath) throws Exception {

        a.setCoverimg(UploadFile.getAlbumID(session,srcpath));
        albumService.addAlbum(a);
    }

}
