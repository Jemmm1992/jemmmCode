package com.jemmm.java.annotation;

import java.lang.annotation.*;

/**
 * Created by xu_zj on 2017/6/30.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PersonSex {
    enum Sex {BOY, GIRL}
    Sex sex() default Sex.BOY;
}
