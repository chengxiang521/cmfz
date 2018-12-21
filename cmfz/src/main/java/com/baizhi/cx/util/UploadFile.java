package com.baizhi.cx.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

public class UploadFile {
    public static String getAlbumID(HttpSession session, MultipartFile srcpath) throws IllegalStateException, IOException {
        ServletContext sc = session.getServletContext();
        String realPath = sc.getRealPath("/upload");
        String[] fies = srcpath.getOriginalFilename().split("\\.");
        String restpath = "/" + fies[0] + System.nanoTime() + "." + fies[1];
        File file = new File(realPath + restpath);
        srcpath.transferTo(file);
        return restpath;
    }
    public static void download(String name, HttpSession session, HttpServletResponse response) throws IOException{
        String path = session.getServletContext().getRealPath("/upload");
        File file=new File(path+name);
        byte[] bs = FileUtils.readFileToByteArray(file);
        System.out.println(file);
        response.setHeader("content-disposition", "attchment;filename="+ URLEncoder.encode(name, "UTF-8"));
        ServletOutputStream out=response.getOutputStream();
        out.write(bs);
        if(out!=null)out.flush();if(out!=null)out.close();
    }

}
