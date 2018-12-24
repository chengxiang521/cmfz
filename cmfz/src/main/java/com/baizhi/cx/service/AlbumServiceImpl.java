package com.baizhi.cx.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.baizhi.cx.dto.PageDto;
import com.baizhi.cx.entity.Album;
import com.baizhi.cx.mapper.AlbumMapper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
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

    @Override
    public void getPoiList() {
        List<Album> albums = albumMapper.queryAllpoicx();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑表", "专辑"),
                Album.class, albums);
        try {
            workbook.write(new FileOutputStream(new File("E:/easypoi.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upPoiList() {
        ImportParams params = new ImportParams();

    }
}
