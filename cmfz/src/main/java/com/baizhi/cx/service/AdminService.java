package com.baizhi.cx.service;

import com.baizhi.cx.entity.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> selectAll();
    public Admin selectByName(Admin admin);
}
