package com.utils.excelUtil_726;

import java.lang.annotation.*;

/**
 * Created by xu_zj on 2017/6/30.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelValueType {
    enum Type {Header, Body}
    Type type() default Type.Body;
}
