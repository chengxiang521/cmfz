package com.baizhi.cx.controller;

import com.baizhi.cx.entity.Admin;
import com.baizhi.cx.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Resource(name = "adminServiceImpl")
    AdminService ad;
    @RequestMapping("all")
    @ResponseBody
    public List<Admin> selectall(){
        List<Admin> list = ad.selectAll();
        return  list;
    }
    @RequestMapping("login")
    public String login(Admin admin){
        try {
            ad.selectByName(admin);
        } catch (Exception e) {
            return  "redirect:/login.jsp";
        }
        return  "main/main";
    }

}
