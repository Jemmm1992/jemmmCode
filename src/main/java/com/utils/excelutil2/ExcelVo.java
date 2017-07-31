package com.utils.excelutil2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xu_zj on 2017/6/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelVo {
    /**
     * 导出的列的名称
     * @return
     */
    String name() default "";

    /**
     * 列的名称，A、B、C、D..
     * @return
     */
    int col() ;

    /**
     * 是否显示在excel中
     * @return
     */
    boolean isExport() default true;
}
