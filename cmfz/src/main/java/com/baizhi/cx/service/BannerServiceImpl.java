package com.baizhi.cx.service;

import com.baizhi.cx.dto.PageDto;
import com.baizhi.cx.entity.Banner;
import com.baizhi.cx.mapper.BannerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource(name = "bannerMapper")
    BannerMapper bannerMapper;
    @Override
    public PageDto<Banner> selectAll(Integer page ,Integer rows) {
        PageDto<Banner> pageDto = new PageDto<>();
        pageDto.setRows( bannerMapper.selectPageall(page,rows));
        pageDto.setTotal(bannerMapper.selectpageCount());
        return pageDto;
    }

    @Override
    public void update(Banner banner) {
       bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public void delete(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addbanner(Banner banner) {
        bannerMapper.addbanner(banner);
    }
}
