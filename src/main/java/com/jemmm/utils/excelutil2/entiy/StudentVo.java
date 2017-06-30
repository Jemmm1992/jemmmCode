package com.jemmm.utils.excelutil2.entiy;

import com.jemmm.utils.excelutil2.annotation.ExcelVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by xu_zj on 2017/6/30.
 */
@Getter
@Setter
@ToString
public class StudentVo {
    @ExcelVo(name = "序号",col = 0)
    private int id;

    @ExcelVo(name = "姓名", col = 1)
    private String name;

    @ExcelVo(name = "年龄", col = 2 ,isExport = true)
    private int age;
}
