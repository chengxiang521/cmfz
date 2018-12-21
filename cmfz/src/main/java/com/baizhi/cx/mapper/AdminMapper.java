package com.baizhi.cx.mapper;

import com.baizhi.cx.entity.Admin;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper extends Mapper<Admin> {
    public Admin queryByName(String name);

}
