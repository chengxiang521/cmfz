package com.baizhi.cx.service;

import com.baizhi.cx.dto.PageDto;
import com.baizhi.cx.entity.Album;
import com.baizhi.cx.mapper.AlbumMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements  AlbumService{
    @Resource(name = "albumMapper")
    AlbumMapper albumMapper;
    @Override

    public PageDto<Album> queryAllcx(Integer page , Integer row) {
        PageDto<Album> albumPageDto = new PageDto<>();
        albumPageDto.setTotal(albumMapper.selectCount(new Album()));
        albumPageDto.setRows(albumMapper.queryAllcx(page, row));
        return albumPageDto;
    }

    @Override
    public Album queryByID(String id) {
        Album admin = albumMapper.queryById(id);
        return admin;
    }

    @Override
    public void addAlbum(Album a) {
        a.setId(UUID.randomUUID().toString().replace("-",""));
        albumMapper.addAlbum(a);
    }
}
