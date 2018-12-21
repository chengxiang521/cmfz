package com.baizhi.cx.service;

import com.baizhi.cx.dto.PageDto;
import com.baizhi.cx.entity.Banner;

import java.util.List;

public interface BannerService {
    public PageDto<Banner>  selectAll(Integer page , Integer row);

    public void update(Banner banner);
    public void delete(Integer id);
    public void addbanner(Banner banner);
}
