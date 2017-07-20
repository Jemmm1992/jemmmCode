package com.jemmm.utils.excelutil3;

import java.text.DecimalFormat;

/**
 * Created by xu_zj on 2017/7/7.
 */
public class test {
    public static void main(String[] args) {
        String s = "13.0000";
        System.out.println(s);
        DecimalFormat df = new DecimalFormat("0.00");
        String s1 = String.valueOf(df.format(Double.valueOf(s)));

        System.out.println(Double.valueOf(s));
        System.out.println(s1);

        String str1 = "abc";
        String str2 = "def";
        String str3 = str1 + str2;
        str3.intern();
        String str4 = "abc" + "def";
        System.out.println(str3 == "abcdef");
        System.out.println(str4 == "abcdef");
//        System.out.println(intern == "abcdef");
    }
}
