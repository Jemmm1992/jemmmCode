package com.utils;

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

        String s = "2017-07-05 13:51:02.14";
        System.out.println(modifyTime(s));
    }

    // 2017-07-05 13:51:02.14 -> 2017-07-05 13:51
    public static  String modifyTime(String time){
        return time.substring(0,time.lastIndexOf(":"));
    }

}
