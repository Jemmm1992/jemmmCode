package com.jemmm.utils.excelutil2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by xu_zj on 2017/6/30.
 */
@Getter
@Setter
@ToString
public class StudentVo2 {
    @ExcelVo(name = "序号",col = 0)
    private int id;

    @ExcelVo(name = "姓名", col = 1)
    private String name;

    @ExcelVo(name = "年龄", col = 2 )
    private int age;

//    @ExcelVo(name = "地址", col = 3)
//    private String address;
//
//    @ExcelVo(name = "成绩", col = 4)
//    private String score;
}
