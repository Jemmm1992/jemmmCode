package com.jemmm.utils.excelutil2;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xu_zj on 2017/6/30.
 * 导入与导出，列固定的，一对一
 */
public class test2 {
    public static final String PATH = "D:\\excelTest2.xlsx";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // 数据集
        List<StudentVo2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentVo2 vo = new StudentVo2();
            vo.setId(i);
            vo.setName("李白" + i);
            vo.setAge(20 + i);
            list.add(vo);
        }
        ExcelRM<StudentVo2> erm = new ExcelRM<>(StudentVo2.class);
        Map<Integer, String> excelHeader = erm.getExcelHeader();
        System.out.println(excelHeader);
        Map<Integer, List<Object>> excelBody = erm.getExcelBody(list);
        System.out.println(excelBody);

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(PATH);
            erm.exportExcel(excelHeader, excelBody, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(PATH);
//            List<StudentVo> ts = erm.importFromExcel("", fis);
//            System.out.println(ts.size());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
