package com.utils.excelUtil_726;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/6.
 * 目前只支持一对一 从excel读取
 */
public class ExcelRMFunction<T> {
    Class<T> clazz;
    // 记录小标题的内容
    private List<CategoryConfigVo> configList;

    public ExcelRMFunction(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<CategoryConfigVo> getConfigList() {
        return configList;
    }

    // 使用private来修饰，保证外界不能修改
    private void setConfigList(List<CategoryConfigVo> configList) {
        this.configList = configList;
    }


    public List<T> importFromExcel(String sheetName, InputStream input) {
        List<T> list = new ArrayList<>();
        try {
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = null;
            if (!sheetName.trim().equals("")) {
                sheet = wb.getSheet(sheetName);
            } else {
                sheet = wb.getSheetAt(0);// 如果sheetName为空，或者sheetName不存在，则默认的指向第一页
            }
            Map<String, Field> excelBaseInfoMap = getExcelBaseInfoField(clazz);
            int numOfRows = sheet.getPhysicalNumberOfRows();// 数据的行数
            if (numOfRows > 0) {
                // 解析头部
                Row headerRow = sheet.getRow(0);
                Map<Integer, String> headerMap = getExcelHeaderValue(headerRow);
                // 解析表内容
                for (int i = 1; i < numOfRows; i++) {
                    Row bodyRow = sheet.getRow(i);
                    // 如果第一列或者第二列都是空的那么就跳过
                    Cell cell1 = bodyRow.getCell(0);
                    Cell cell2 = bodyRow.getCell(1);
                    String cellValue1 = getValueFromCell(cell1);
                    String cellValue2 = getValueFromCell(cell2);
                    if (!StringUtils.isBlank(cellValue1) || !StringUtils.isBlank(cellValue2)) {
                        Map<Integer, String> bodyMap = getExcelBodyValue(bodyRow);
                        T entity = clazz.newInstance();
                        setExcelBaseInfo(entity, bodyRow, excelBaseInfoMap, headerMap);
                        setExcelDetailMap(entity, headerMap, bodyMap);
                        if (entity != null) {
                            list.add(entity);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * 设置entity中的ExcelAnnotation注解修饰的属性
     */
    public void setExcelBaseInfo(Object entity, Row bodyRow, Map<String, Field> excelBaseInfoMap, Map<Integer, String> headerMap)
            throws IllegalAccessException {
        for (int i = 0; i < bodyRow.getPhysicalNumberOfCells(); i++) {
            Cell cell = bodyRow.getCell(i);
            String cellValue = getValueFromCell(cell);
            Field field = excelBaseInfoMap.get(headerMap.get(i));
            if (field != null && !StringUtils.isBlank(cellValue))
                setFieldValue(entity, field, cellValue);// 给entity中的field赋值
        }
    }

    /**
     * 设置entity中ExcelValueType修饰的的属性
     */
    public void setExcelDetailMap(Object entity, Map<Integer, String> headerMap, Map<Integer, String> bodyMap) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ExcelValueType.class)) {
                ExcelValueType annotation = field.getAnnotation(ExcelValueType.class);
                if (annotation.type() == ExcelValueType.Type.Header) {
                    field.set(entity, headerMap);
                } else if (annotation.type() == ExcelValueType.Type.Body) {
                    field.set(entity, bodyMap);
                }
            }
        }
    }

    /**
     * 获取excel表头的值
     */
    private Map<Integer, String> getExcelHeaderValue(Row headerRow) {
        List<CategoryConfigVo> list = new ArrayList<>();
        Map<Integer, String> map = new LinkedHashMap<>();
        int k = 0;
        int numOfCols = headerRow.getPhysicalNumberOfCells(); // 获取列头的数
        for (int i = 0; i < numOfCols; i++) {
            Cell cell = headerRow.getCell(i);
            String cellValue = getValueFromCell(cell);
            // 检测到时小标题
            if (cellValue.length() != 0 && cellValue.indexOf("#") == cellValue.length() - 1) {
                CategoryConfigVo vo = new CategoryConfigVo();
                vo.setCategoryName(cellValue.replace("#", ""));
                vo.setBeginIndex(i + 1);
                if (k > 0) {
                    list.get(k - 1).setEndIndex(i - 1);
                }
                k++;
                list.add(vo);
            } else {
                if (!StringUtils.isBlank(cellValue))//Map中只存非空的值
                    map.put(i, cellValue);
            }
        }
        if (k > 0)
            list.get(list.size() - 1).setEndIndex(numOfCols - 1);
        setConfigList(list);
        return map;
    }

    /**
     * 获取excel表内容的值，key和表头map中的key一一对应
     */
    private Map<Integer, String> getExcelBodyValue(Row bodyRow) {
        Map<Integer, String> map = new LinkedHashMap<>();
        int numOfCols = bodyRow.getPhysicalNumberOfCells(); // 获取列的数
        for (int i = 0; i < numOfCols; i++) {
            Cell cell = bodyRow.getCell(i);
            String cellValue = getValueFromCell(cell);
            if (!StringUtils.isBlank(cellValue))
                map.put(i, cellValue);
        }
        return map;
    }

    // 获取ExcelAnnotation中基本filed的集合
    public Map<String, Field> getExcelBaseInfoField(Class clazz) {
        Map<String, Field> map = new LinkedHashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        int i = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelAnnotation.class)) {
                ExcelAnnotation annotation = field.getAnnotation(ExcelAnnotation.class);
                map.put(annotation.name(), field);
            }
        }
        return map;
    }

    /**
     * 获取单元格值
     */
    public static String getValueFromCell(Cell cell) {
        String cellStringValue;
        if (cell == null) {
            return "";
        }
        DataFormatter formatter = new DataFormatter();
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING: // 字符串
                cellStringValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC: // 数字
                if (DateUtil.isCellDateFormatted(cell)) {
                    DataFormatter f = new DataFormatter();
                    cellStringValue = f.formatCellValue(cell);
                } else {
                    String s = cell.toString();
                    if (s.contains("E")) {
                        //证件号码或者手机号码
                        DecimalFormat format = new DecimalFormat("#");
                        Number value = cell.getNumericCellValue();
                        cellStringValue = format.format(value);
                    } else {
                        double value = cell.getNumericCellValue();
                        int intValue = (int) value;
                        cellStringValue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
                    }
                }
                break;
            case Cell.CELL_TYPE_FORMULA:
                cellStringValue = String.valueOf(cell.getCellFormula());  // 公式
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellStringValue = String.valueOf(cell.getBooleanCellValue()); //　布尔值
                break;
            case HSSFCell.CELL_TYPE_BLANK: // 空值
                cellStringValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                cellStringValue = "";
                break;
            default:
                cellStringValue = cell.getStringCellValue();// 默认是Cell.CELL_TYPE_STRING 字符串
        }
        return cellStringValue.trim();
    }

    public static void setFieldValue(Object entity, Field field, String cellValue) throws IllegalAccessException {
        if (field == null) return;
        Class<?> fieldType = field.getType();
        field.setAccessible(true);
        if (String.class == fieldType) {
            field.set(entity, String.valueOf(cellValue));
        } else if ((Integer.class == fieldType) || (Integer.TYPE == fieldType)) {
            field.set(entity, Integer.parseInt(cellValue));
        } else if ((Long.class == fieldType) || (Long.TYPE == fieldType)) {
            field.set(entity, Long.valueOf(cellValue));
        } else if ((Float.class == fieldType) || (Float.TYPE == fieldType)) {
            field.set(entity, Float.valueOf(cellValue));
        } else if ((Short.class == fieldType) || (Short.TYPE == fieldType)) {
            field.set(entity, Short.valueOf(cellValue));
        } else if ((Double.class == fieldType) || (Double.TYPE == fieldType)) {
            field.set(entity, Double.valueOf(cellValue));
        } else if (Character.class == fieldType || Character.TYPE == fieldType) {
            if ((cellValue != null) && (cellValue.length() > 0)) {
                field.set(entity, Character.valueOf(cellValue.charAt(0)));
            }
        }
    }

    // 列头样式
    public static CellStyle getHeaderStyle(SXSSFWorkbook wb) {
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());// 设置背景色
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
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
    public static CellStyle getCellStyle(SXSSFWorkbook wb) {
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
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

