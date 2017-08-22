package com.zhenti.wangyi.qiuzhao2017;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p2_youyadedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(get(a));
    }

    public static int get(int a) {
        int r = (int) Math.sqrt(a);
        int l = 0;
        int cnt = 0;
        boolean b = false;
        if (r * r == a) {
            cnt += 4;
            l++;
            r--;
        }
        while (l <= r) {
            if (l * l + r * r == a) {
                if (l != r) cnt += 8;
                else cnt += 4;
                l++;
                r--;
            } else if (l * l + r * r > a) {
                r--;
            } else {
                l++;
            }
        }
        return cnt;
    }
}
