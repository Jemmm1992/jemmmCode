package com.jemmm.utils.execelUtil;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu_zj on 2017/6/30.
 */
public class ExcelUtilTest {

    private Logger logger = Logger.getLogger(ExcelUtilTest.class);

    @Test
    public void exportExcel(){
        // 初始化数据
        List<StudentVO> list = new ArrayList<StudentVO>();

        StudentVO vo = new StudentVO();
        vo.setId(1);
        vo.setName("李坤");
        vo.setAge(26);
        vo.setClazz("五期提高班");
        vo.setCompany("天融信");
        list.add(vo);

        StudentVO vo2 = new StudentVO();
        vo2.setId(2);
        vo2.setName("曹贵生");
        vo2.setClazz("五期提高班");
        vo2.setCompany("中银");
        list.add(vo2);

        StudentVO vo3 = new StudentVO();
        vo3.setId(3);
        vo3.setName("柳波");
        vo3.setClazz("五期提高班");
        list.add(vo3);

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("d:\\success3.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ExcelUtil<StudentVO> util = new ExcelUtil<StudentVO>(StudentVO.class);// 创建工具类.
        util.exportExcel(list, "学生信息", out);// 导出
        logger.info("----执行完毕----------");
    }

    @Test
    public void importExcel(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("d:\\success3.xls");
            ExcelUtil<StudentVO> util = new ExcelUtil<StudentVO>(
                    StudentVO.class);// 创建excel工具类
            List<StudentVO> list = util.importExcel("学生信息0", fis);// 导入
            logger.info(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}