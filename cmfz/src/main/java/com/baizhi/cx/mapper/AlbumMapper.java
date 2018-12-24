package com.baizhi.cx.mapper;

import com.baizhi.cx.entity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
public List<Album> queryAllcx(@Param("page") Integer page, @Param("row")Integer row);
public List<Album> queryAllpoicx();
public Album queryById(String id);
public void addAlbum(Album a);
public void updatealbum(String id);
}
