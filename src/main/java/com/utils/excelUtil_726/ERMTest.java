package com.utils.excelUtil_726;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by xu_zj on 2017/7/26.
 * case1:标准
 * case2:某一个单元格的内容为空
 * case3:带小标题
 * case4:支持日期 时间的读取
 */
public class ERMTest {
    public static void main(String[] args) {
        String excelUrl = "adidas改好的表格0815.xlsx";
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
        List<TravelerInfoVo> travelerInfoVos = erm.importFromExcel("", is);
        List<CategoryConfigVo> categoryConfigVos = erm.getConfigList();
        return travelerInfoVos;
    }
}
