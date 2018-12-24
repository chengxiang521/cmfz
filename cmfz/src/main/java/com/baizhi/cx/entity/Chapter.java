package com.baizhi.cx.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chapter")
public class Chapter implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Excel(name = "编号")
    private Integer id;
    @Excel(name = "名字")
    private String title;
    @Excel(name = "大小")
    private String size;
    @Excel(name = "时长")
    private String duration;
    @ExcelIgnore
    private String chpath;
    @Excel(name = "日期",format = "YYYY-MM-dd",width = 20)
    private Date uploaddate;
    @ExcelIgnore
    private String albumid;

}
