package com.jemmm.utils.excelutil2;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by BIG-JIAN on 2017/6/30.
 */
public class ExcelRM<T> {
    Class<T> clazz;

    public ExcelRM(Class<T> clazz) {
        this.clazz = clazz;
    }


    /**
     * 思路：
     * 1. 从vo类中通过反射来读取field
     */
    public List importFromExcel(String sheetName, InputStream input) {
        List<T> list = new ArrayList<>();
        try {
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = null;
            if (!sheetName.trim().equals("")) {
                sheet = wb.getSheet(sheetName);
            }
            if (sheet == null) {
                sheet = wb.getSheetAt(0);// 如果sheetName为空，或者sheetName不存在，则默认的指向第一页
            }
            Map<Integer, Field> fieldMap = getFieldMap(clazz);

            int numberOfRows = sheet.getPhysicalNumberOfRows();
            Map<Integer, String> excelHeader = getExcelHeader();
            int colNum = excelHeader.size();
            if (numberOfRows > 0) {
                // 从第二行开始读取数据
                for (int i = 1; i < numberOfRows; i++) {
                    XSSFRow row = sheet.getRow(i);
                    T entity = null;
                    for (int j = 0; j < colNum; j++) {
                        XSSFCell cell = row.getCell(j);
                        if (cell == null) continue;
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        if (cellType == XSSFCell.CELL_TYPE_NUMERIC) {
                            cellValue = String.valueOf(cell.getNumericCellValue());
                        } else if (cellType == XSSFCell.CELL_TYPE_BOOLEAN) {
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                        } else {
                            cellValue = cell.getStringCellValue();
                        }
                        if (cellValue == null || cellValue.equals("")) {
                            continue;
                        }
                        entity = (entity == null ? clazz.newInstance() : entity);// 如果不存在实例则新建.
                        Field field = fieldMap.get(j);
                        if (field == null) continue;
                        Class<?> fieldType = field.getType();

                        field.setAccessible(true);
                        if (String.class == fieldType) {
                            field.set(entity, String.valueOf(cellValue));
                        } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                            field.set(entity, Integer.parseInt(cellValue));
                        } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                            field.set(entity, Float.valueOf(cellValue));
                        } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                            field.set(entity, Long.valueOf(cellValue));
                        } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                            field.set(entity, Short.valueOf(cellValue));
                        } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                            field.set(entity, Double.valueOf(cellValue));
                        } else if (Character.TYPE == fieldType) {
                            if ((cellValue != null) && (cellValue.length() > 0)) {
                                field.set(entity, Character.valueOf(cellValue.charAt(0)));
                            }
                        }
                    }
                    if (entity != null) {
                        list.add(entity);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<Integer, Field> getFieldMap(Class clazz) {
        Map<Integer, Field> map = new LinkedHashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelVo.class)) {
                ExcelVo annotation = field.getAnnotation(ExcelVo.class);
                if (annotation.isExport()) {
                    map.put(annotation.col(), field);
                }
            }
        }
        return map;
    }


    public void exportExcel(Map<Integer, String> excelHeader, Map<Integer, List<Object>> excelBody, FileOutputStream out) {
        // rowAccessWindowSize代表指定的内存中缓存记录数
        // 举个例子：内存中限制行数为100，当行号到达101时，行号为0的记录刷新到硬盘并从内存中删除，以此类推
        // 默认为100
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        // SXSSF在把内存数据刷新到硬盘时，是把每个SHEET生成一个临时文件，这个临时文件可能会很大。
        // 这是可以使用setCompressTempFiles
        wb.setCompressTempFiles(true);
        CellStyle headerStyle = getHeaderStyle(wb);// 列头样式
        CellStyle cellStyle = getCellStyle(wb);// 单元格样式
        SXSSFSheet sheet = wb.createSheet();// 创建一个表
        sheet.trackAllColumnsForAutoSizing();
        sheet.createFreezePane(0, 1, 0, 1);// 冻结第一行
        // 生成表的头部标题
        SXSSFRow headerRow = sheet.createRow(0); //列头 rowIndex =0
        headerRow.setHeightInPoints(30);//设置单元格高度
        for (Iterator<Map.Entry<Integer, String>> iterator = excelHeader.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, String> next = iterator.next();
            Integer key = next.getKey();
            String value = next.getValue();
            headerRow.createCell(key).setCellValue(value);
            headerRow.getCell(key).setCellStyle(headerStyle);
        }
        for (int i = 1; i <= excelBody.get(0).size(); i++) {
            SXSSFRow row = sheet.createRow(i);
            row.setHeightInPoints(20);
        }
        for (Iterator<Map.Entry<Integer, List<Object>>> iterator = excelBody.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, List<Object>> next = iterator.next();
            Integer key = next.getKey();
            List<Object> value = next.getValue();
            for (int i = 1; i <= value.size(); i++) {
                SXSSFRow row = sheet.getRow(i);
                SXSSFCell cell = row.createCell(key);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                Object o = value.get(i - 1);
                String cellValue = "";
                if (o == null) {
                    cellValue = "";
                } else if (o instanceof Date) {
                    cellValue = new SimpleDateFormat("yyyy年MM月dd日").format(o);
                } else if (o instanceof Float || o instanceof Double) {
                    cellValue = new BigDecimal(o.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                } else {
                    cellValue = o.toString();
                }
                cell.setCellValue(cellValue);
                cell.setCellStyle(cellStyle);
            }
        }
        // 自动调整宽度
        for (int i = 0; i < excelHeader.size(); i++) {
            sheet.autoSizeColumn(i);
        }
        try {
            wb.write(out);
            wb.close();
            wb.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据传入的 对象集合 提取每一列的数据
     *
     * @param list
     * @throws IllegalAccessException
     */
    public Map<Integer, List<Object>> getExcelBody(List list) throws IllegalAccessException {
        Map<Integer, List<Object>> map = new LinkedHashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            ExcelVo annotation = field.getAnnotation(ExcelVo.class);
            if (annotation.isExport()) {
                List<Object> l = new ArrayList<>();
                Object o = null;
                for (int i = 0; i < list.size(); i++) {
                    o = list.get(i);
                    l.add(field.get(o));
                }
                map.put(annotation.col(), l);
            }
        }
        return map;
    }

    /**
     * 根据实体类中的注解拿到excel中的列头
     *
     * @return
     */
    public Map<Integer, String> getExcelHeader() {
        Map<Integer, String> map = new LinkedHashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ExcelVo.class)) {
                ExcelVo annotation = field.getAnnotation(ExcelVo.class);
                // 如果Export设置为false，就不导出到excel中，默认为false
                if (annotation.isExport()) map.put(annotation.col(), annotation.name());
            }
        }
        return map;
    }

    // 列头样式
    public CellStyle getHeaderStyle(SXSSFWorkbook wb) {
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());// 设置背景色
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 16);//设置字体大小
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        headerStyle.setFont(font);//选择需要用到的字体格式
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return headerStyle;
    }

    // cell样式
    public CellStyle getCellStyle(SXSSFWorkbook wb) {
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);//设置字体大小
        headerStyle.setFont(font);//选择需要用到的字体格式
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return headerStyle;
    }
}
