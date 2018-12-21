package com.baizhi.cx.controller;

import com.baizhi.cx.dto.PageDto;
import com.baizhi.cx.entity.Banner;
import com.baizhi.cx.service.BannerService;
import com.baizhi.cx.util.UploadFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Resource(name = "bannerServiceImpl")
    BannerService bannerService;

    @RequestMapping("all")
    public PageDto<Banner> getall(Integer page, Integer rows) {
        return bannerService.selectAll(page, rows);
    }

    @RequestMapping("update")
    public void upbanner(Banner banner) {
        bannerService.update(banner);
    }

    @RequestMapping("del")
    public void delbanner(Integer id) {
        bannerService.delete(id);
    }
    @RequestMapping("add")
    @ResponseBody
    public void addbanner(Banner banner, HttpSession session, MultipartFile srcpath) throws IllegalStateException, IOException {
        banner.setImgpath(UploadFile.getAlbumID(session,srcpath));
        bannerService.addbanner(banner);
    }
}
