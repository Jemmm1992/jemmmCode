package com.jemmm.java.annotation;

import java.lang.annotation.*;

/**
 * Created by xu_zj on 2017/6/30.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Person {
    String name() default "荆轲";
    int age() default 20;
    String[] hobby() default{"王者荣耀","刀塔","英雄联盟"};
}

/**
 * 自定义注解
 * java允许我们自定义注解，它提供了元注解用于自定义注解
 * 1.1 元注解
 * 元注解负责注解自定义注解
 * 1. @Target: 说明注解可以用的地方
 *       -- CONSTRUCTOR:构造器
 *       -- FIELD: 变量
 *       -- LOCAL_VARIABLE: 局部变量
 *       -- METHOD: 方法
 *       -- PACKAGE: 包
 *       -- PARAMETER: 参数
 *       -- TYPE: 类、接口、enum
 * FE: @Target(ElementType.FIELD)
 *
 * 2. @Retention: 自定义注解的生命周期
 *       -- SOURCE: 在源文件中有效
 *       -- CLASS: 在class文件中有效
 *       -- RUNTIME: 在运行时有效
 * FE: @Retention(RetentionPolicy.RUNTIME)
 *
 * 3. @Documented：表明自定义注解可以被javadoc文档化
 * FE: @Documented
 *
 * 4. @Inherited:
 * 使用此注解声明出来的自定义注解，在使用此自定义注解时，
 * 如果注解在类上面时，子类会自动继承此注解,否则的话，子类不会继承此注解。
 * 这里一定要记住，使用Inherited声明出来的注解，只有在类上使用时才会有效，对方法，属性等其他无效。
 */



