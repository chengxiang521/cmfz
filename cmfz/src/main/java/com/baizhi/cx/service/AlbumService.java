package com.baizhi.cx.service;

import com.baizhi.cx.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> queryAllcx();
    public Album queryByID(String id);
    public void addAlbum(Album a);
}
