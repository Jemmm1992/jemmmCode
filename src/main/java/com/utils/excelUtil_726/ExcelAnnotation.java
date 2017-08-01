package com.utils.excelUtil_726;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xu_zj on 2017/6/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
    /**
     * 列的名称
     * @return
     */
    String name() default "";

    String type() default "body";

}
