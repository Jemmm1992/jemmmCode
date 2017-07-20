package com.jemmm.utils.excelutil3;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by xu_zj on 2017/6/30.
 */
public class test3 {
    public static final String PATH = "E:\\出行人表格1.xlsx";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        ExcelRM2<TravelerBaseInfoVo> erm = new ExcelRM2<>(TravelerBaseInfoVo.class);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PATH);
            List<TravelerBaseInfoVo> ts = erm.importFromExcel("", fis);
            System.out.println(ts.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
