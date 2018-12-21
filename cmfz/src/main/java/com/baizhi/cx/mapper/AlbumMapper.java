package com.baizhi.cx.mapper;

import com.baizhi.cx.entity.Album;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
public List<Album> queryAllcx();
public Album queryById(String id);
public void addAlbum(Album a);
}
