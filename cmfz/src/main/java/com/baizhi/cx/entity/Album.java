package com.baizhi.cx.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
@ExcelTarget("album")
public class Album implements Serializable {
    @Id
    @ExcelIgnore
    private String id;
    @Excel(name = "专辑的名字",needMerge = true)
    private String title;
    @ExcelIgnore
    private Integer count;
    @Excel(name = "专辑的图片",type = 2 ,width = 40 , height = 20,needMerge = true)
    private String coverimg;
    @ExcelIgnore
    private Integer score;
    @ExcelIgnore
    private String author;
    @ExcelIgnore
    private String broadcast;
    @ExcelIgnore
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @ExcelIgnore
    private Date pubdate;
    @Transient
    @ExcelCollection(name = "章节")
    private List<Chapter> children;

}
