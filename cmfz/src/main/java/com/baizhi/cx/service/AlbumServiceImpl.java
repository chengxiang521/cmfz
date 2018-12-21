package com.baizhi.cx.service;

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
    public List<Album> queryAllcx() {
        return albumMapper.queryAllcx();
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
