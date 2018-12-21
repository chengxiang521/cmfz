package com.baizhi.cx.controller;

import com.baizhi.cx.entity.Menu;
import com.baizhi.cx.service.MenuService;
import com.baizhi.cx.service.MenuServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Resource(name = "menuServiceImpl")
    MenuService menuService;

    @RequestMapping("all")
    @ResponseBody
    public List<Menu> selectAll() {
        List<Menu> list = menuService.selectall();
        return list;
    }
}
