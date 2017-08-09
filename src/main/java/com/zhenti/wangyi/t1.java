package com.zhenti.wangyi;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/5.
 * https://www.nowcoder.com/test/question/56a487c342a64d2ea4c3a0b0144b42d0?pid=4111169&tid=9600840
 * AAAABCCDAA会被编码成4A1B2C1D2A
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(get(s));
    }

    public static String get(String s) {
        int num = 1;
        char c = s.charAt(0);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                num++;
            } else {
                sb.append(num).append(s.charAt(i - 1));
                num = 1;
                c = s.charAt(i);
            }
        }
        sb.append(num).append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}
//AAAABCCDAA