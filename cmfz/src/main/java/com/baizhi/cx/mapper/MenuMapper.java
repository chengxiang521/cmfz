package com.baizhi.cx.mapper;

import com.baizhi.cx.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    public List<Menu> selectPall();
}
