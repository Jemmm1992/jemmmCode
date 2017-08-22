package com.utils.excelUtil_726;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by xu_zj on 2017/7/10.
 */
@Getter
@Setter
@ToString
public class TravelerBaseInfoVo {
    private Long travelerExcelID;
    private Long travelersBaseInfoID;

    private int colNum;
    private String FieldName;
    private String FieldValue;
}
