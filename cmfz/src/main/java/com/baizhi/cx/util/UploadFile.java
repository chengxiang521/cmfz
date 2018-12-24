package com.baizhi.cx.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

public class UploadFile {
    public static String getAlbumID(HttpSession session, MultipartFile srcpath) throws IllegalStateException, IOException {
        String realPath = session.getServletContext().getRealPath("/upload");
        File file1 = new File(realPath);
        if(!file1.exists()){
            file1.mkdir();
        }
        String originalFilename = srcpath.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String replace = UUID.randomUUID().toString().replace("-", "");
        String restpath=replace+"."+extension;
        File file = new File(realPath +"/"+ restpath);
        srcpath.transferTo(file);
        return restpath;
    }
    public static void download(String title,String name, HttpSession session, HttpServletResponse response) throws IOException{
        String path = session.getServletContext().getRealPath("/upload");
        File file=new File(path+"/"+name);
        byte[] bs = FileUtils.readFileToByteArray(file);
        response.setHeader("content-disposition", "attchment;filename="+ URLEncoder.encode(title, "UTF-8"));
        ServletOutputStream out=response.getOutputStream();
        out.write(bs);
        if(out!=null)out.flush();if(out!=null)out.close();
    }

}
