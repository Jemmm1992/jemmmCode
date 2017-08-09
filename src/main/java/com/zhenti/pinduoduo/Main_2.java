package com.zhenti.pinduoduo;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/1.
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(mul(str1, str2));
    }

    public static String mul(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0;
        for (i = 0; i < s1.length() + s2.length(); i++) {
            sb.append('0');
        }
        int k = 0, add = 0, temp = 0;
        for (j = s2.length() - 1; j >= 0; j--) {
            if (s2.charAt(j) != '0') {
                for (i = s1.length() - 1; i >= 0; i--) {
                    k = i + j + 1;
                    temp = (s2.charAt(j) - '0') * (s1.charAt(i) - '0') + (sb.charAt(k) - '0');
                    sb.setCharAt(k--, (char) ('0' + temp % 10));
                    add = temp / 10;
                    while (add != 0) {
                        temp = add + sb.charAt(k) - '0';
                        sb.setCharAt(k--, (char) ('0' + temp % 10));
                        add = temp / 10;
                    }
                }
            }
        }
        if (sb.charAt(0) == '0')
            return sb.substring(1);
        else
            return sb.toString();
    }
}
