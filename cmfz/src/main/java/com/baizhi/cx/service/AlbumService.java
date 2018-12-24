package com.baizhi.cx.service;

import com.baizhi.cx.dto.PageDto;
import com.baizhi.cx.entity.Album;

import java.util.List;

public interface AlbumService {
    public PageDto<Album> queryAllcx(Integer page , Integer row);
    public Album queryByID(String id);
    public void addAlbum(Album a);
    public void getPoiList();
    public void upPoiList();
}
