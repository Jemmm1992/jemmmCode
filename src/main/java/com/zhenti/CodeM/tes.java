package com.zhenti.CodeM;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/7/30.
 * 给定两个整数 l 和 r ，对于所有满足1 ≤ l ≤ x ≤ r ≤ 10^9 的 x ，把 x 的所有约数全部写下来。对于每个写下来的数，只保留最高位的那个数码。求1～9每个数码出现的次数。
 * 输入描述:
 * 一行，两个整数 l 和 r (1 ≤ l ≤ r ≤ 10^9)。
 * 输出描述:
 * 输出9行。
 * 第 i 行，输出数码 i 出现的次数。
 * 输入例子1:
 * 1 4
 * 输出例子1:
 * 4
 * 2
 * 1
 * 1
 * 0
 * 0
 * 0
 * 0
 * 0
 * https://www.nowcoder.com/test/question/a69696beeec24ba784fae9e34c8ab2da?pid=5513596&tid=9464445
 */

public class tes {
    int mx = (int) (1e5 + 10);
    int n, m, len, mid;
    static long cnt[] = new long[11];
    char str[] = new char[15];

    static long get_sum(int l, int r, int x) {
        long ans = 0;
        r = Math.min(r, x);
        int k = x / r;
        while (true) {
            k = x / r;
            int d = x / (k + 1);
            if (d < l) break;
            ans += k * (r - d);
            r = d;
        }
        ans += (r - l + 1) * k;
        return ans;
    }

    static void work(int x, int v) {
        for (int i = 1; i < 10; i++) {
            int rode = 1;
            while ((long) 1 * i * rode <= x) {
                int rr = i * rode + rode - 1;
                cnt[i] += v * get_sum(i * rode, rr, x);
                rode *= 10;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            work(m, 1);
            work(n - 1, -1);
            for (int i = 1; i < 10; i++)
                System.out.println(cnt[i]);
        }
    }
}
