package com.jemmm.java.annotation;

import java.lang.reflect.Field;

/**
 * Created by xu_zj on 2017/6/30.
 */
public class AnnotationProcessor {
    public static void getInfo(Class<?> clazz){
        // 对类上的注解解析
        if(clazz.isAnnotationPresent(Person.class)){
            Person annotation = clazz.getAnnotation(Person.class);
            System.out.println(annotation);
            System.out.println(annotation.age());
            System.out.println(annotation.name());
            String[] hobby = annotation.hobby();
            for(String str : hobby){
                System.out.println(str);
            }
        }
        // 对field上的注解解析
        Field[] fields = clazz.getDeclaredFields();
        for(Field field :fields){
            System.out.println("fileTypeName:" + field.getType().getName());
            System.out.println("fieldName=" + field.toString());
            if(field.isAnnotationPresent(PersonSex.class)){
                PersonSex annotation = (PersonSex)field.getAnnotation(PersonSex.class);
                System.out.println(annotation);
                System.out.println(annotation.sex());
            }
        }
    }
}
