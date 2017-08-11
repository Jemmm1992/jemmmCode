package com.zhenti.other;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/5.
 * 远景能源：判断t是否是s的子序列
 */
public class p_yuanjign_0805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(get(sc.next(), sc.next()));
        }
    }

    public static String get(String s1, String s2) {
        int old = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            if (old != s1.length() || i == 0) {
                old = s1.length();
                s1 = s1.replaceFirst(String.valueOf(s2.charAt(i)), "");
            } else {
                return "No";
            }
        }
        if (old != s1.length()) {
            return "Yes";
        } else {
            return "No";
        }
    }
}

