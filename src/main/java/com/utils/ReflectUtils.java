package com.utils;

import com.utils.excelutil2.ExcelVo;
import org.apache.poi.ss.formula.functions.T;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import static com.utils.PrintfUtils.printf;

/**
 * Created by xu_zj on 2017/6/30.
 */
public class ReflectUtils {
    public static void reflect(Class<T> clazz){
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            printf("field.getName()",field.getName());
            printf("field.getType().getName()",field.getType().getName());
        }
    }

    /**
     * 输出List
     */
    public static void reflect(List list, Class<?> clazz, Class<? extends Annotation> annotationsClass) throws IllegalAccessException, InstantiationException {
        // getFields()只能取public字段，getDeclaredFields()可以取到各种字段
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i <fields.length ; i++) {
            fields[i].setAccessible(true);
            printf("Name" , fields[i].getName());
            printf("Type",fields[i].getType().getName());
            if(fields[i].isAnnotationPresent(annotationsClass)){
                Annotation[] annotations = annotationsClass.getAnnotations();
                Field[] declaredFields = annotationsClass.getDeclaredFields();
                for (Field a:declaredFields) {
                    printf(a.toString());
                }
                ExcelVo annotation = (ExcelVo) fields[i].getAnnotation(annotationsClass);
                System.out.println("annotation: " + annotation);
                System.out.println("name: " + annotation.name());
                System.out.println("age: " + annotation.col());
                System.out.println("isExport: " + annotation.isExport());
            }
            try {
                for(int j = 0 ; j < list.size();j++){
                    System.out.println("FieldValue: " + fields[i].get(list.get(j)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}
