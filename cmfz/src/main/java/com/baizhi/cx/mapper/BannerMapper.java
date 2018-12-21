package com.baizhi.cx.mapper;

import com.baizhi.cx.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    public void addbanner(Banner b);
    //查询有多少条数据
    public Integer selectpageCount();
    //查询改页的所有行，返回list
    public List<Banner> selectPageall(@Param("page") Integer page,@Param("row")Integer row);
}
