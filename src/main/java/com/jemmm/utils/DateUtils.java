package com.jemmm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xu_zj on 2017/6/23.
 */
public class DateUtils {
    public static void main(String[] args) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}
