package com.jemmm.utils.excelUtil_726;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by xu_zj on 2017/7/26.
 */
public class ERMTest {
    public static void main(String[] args) {
        String excelUrl = "出行人表格.xlsx";
        List<TravelerInfoVo> traverlerInfoVo = getTraverlerInfoVo(excelUrl);
        System.out.println(traverlerInfoVo.size());
    }

    /**
     * 读取上传的excel内的内容
     *
     * @param excelUrl
     * @return
     */
    public static List<TravelerInfoVo> getTraverlerInfoVo(String excelUrl) {
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(new File(excelUrl)));
        } catch (Exception e) {
            System.out.println(e);
        }
        // 解析excel表内容
        ExcelRMFunction<TravelerInfoVo> erm = new ExcelRMFunction<>(TravelerInfoVo.class);
        List<TravelerInfoVo> list = erm.importFromExcel("", is);
        return list;
    }
}
