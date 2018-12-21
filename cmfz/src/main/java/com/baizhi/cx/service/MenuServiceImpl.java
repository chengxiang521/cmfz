package com.baizhi.cx.service;

import com.baizhi.cx.entity.Menu;
import com.baizhi.cx.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements  MenuService {
    @Resource(name = "menuMapper")
    MenuMapper menuMapper;
    @Override
    public List<Menu> selectall() {
        return menuMapper.selectPall();
    }
}
