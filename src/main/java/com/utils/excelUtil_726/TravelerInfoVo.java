package com.utils.excelUtil_726;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

/**
 * Created by xu_zj on 2017/7/26.
 */
@Getter
@Setter
@ToString
public class TravelerInfoVo {
    //主键ID
    private Long TravelersBaseInfoID;
    // 关联的出行人表格ID
    private Long TravelerExcelID;

    // 出行人姓名
    @ExcelAnnotation(name= "姓名")
    private String TravelerName;

    // 证件类型
    @ExcelAnnotation(name = "证件类型")
    private String cardType;

    // 证件号码
    @ExcelAnnotation(name = "证件号码")
    private String cardCode;

    // 联系手机号
    private String telephone;
    // 数据创建时间
    private Timestamp createTime;
    // 数据修改时间
    private Timestamp LastTime;

    // excel表的表头值,比如<1,姓名>，<2,年龄>,<3,证件类型>...
    @ExcelValueType(type = ExcelValueType.Type.Header)
    private LinkedHashMap<Integer,String> excelHeaderMap;

    @ExcelValueType(type = ExcelValueType.Type.Body)
    private LinkedHashMap<Integer,String> excelBodyMap;
}
