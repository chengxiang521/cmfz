package com.baizhi.cx.service;

import com.baizhi.cx.entity.Admin;
import com.baizhi.cx.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource(name = "adminMapper")
    private AdminMapper am;

    @Override
    public List<Admin> selectAll() {
        List<Admin> list = am.selectAll();
        return list;
    }

    @Override
    public Admin selectByName(Admin admin) {
        Admin sadmin = am.queryByName(admin.getName());
        if (sadmin==null){throw new RuntimeException("账户错误");}
        if (!sadmin.getPwd().equals(admin.getPwd())){throw new RuntimeException("密码错误");}
        return admin;
    }
}
