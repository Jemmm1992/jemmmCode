package com.zhenti.tengxun;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/14.
 * 腾讯2018校招
 */
public class a1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        if (Integer.valueOf(s[0]) < 3) {
            System.out.println("incorrect data");
        } else {
            if (check(s[1]) == false || check(s[2]) == false) System.out.println("incorrect data");
            else {
                String ss = "";
                int x = getX(s[1], s[2]);
                int cn = x / (15 * Integer.valueOf(s[0])) + 1;
                ss += cn + ",";
                int cx = x % (15 * Integer.valueOf(s[0]));
                int kn = cx / 15 + 1;   // 输出
                ss += kn + "-";
                int kx = cx % 15;   // 判断
                if (kx <= 5) {
                    ss += kn;
                } else {
                    ss += kn + 1;
                }
                System.out.println(ss);
            }
        }
    }

    public static int getX(String s1, String s2) {
        String[] split1 = s1.split(" ")[1].split(":");
        String[] split2 = s2.split(" ")[1].split(":");
        int k1 = Integer.valueOf(split2[0]) - Integer.valueOf(split1[0]);
        int k2 = Integer.valueOf(split2[1]) - Integer.valueOf(split1[1]);
        return k1 * 60 + k2;
    }

    public static boolean check(String s) {
        String[] s1 = s.split(" ");
        String[] s2 = s1[1].split(":");

        for (int i = 0; i < s2.length; i++) {
            int k = Integer.valueOf(s2[i]);
            if (i == 0) {
                if (k < 0 || k > 24) return false;
            } else if (i == 1) {
                if (k < 0 || k > 60) return false;
            }
        }
        return true;
    }
}
