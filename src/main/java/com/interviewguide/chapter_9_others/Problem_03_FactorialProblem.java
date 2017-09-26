package com.interviewguide.chapter_9_others;

/**
 * Created by BIG-JIAN on 2017/9/6.
 */
public class Problem_03_FactorialProblem {
    /**
     * 求阶乘的位数
     */
    public static void main(String[] args) {
        System.out.println(getN(10));
        System.out.println(get_digit_lib(getN(10))); // 常规方法，思路先求出N！,再求位数
        System.out.println(getDigit(10)); // log(n!) = log(1) + .. + log(n)
        System.out.println(getDigit2(10)); // 斯特林方法
    }


    /**
     * 求N的阶乘
     */
    public static int getN(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }

    /**
     * 使用log10 求一个阶乘的位数
     * 思路： log10(n!) = log(1) + ... + log(n)
     */
    public static int getDigit(int n) {
        double digit = 0;
        for (int i = 1; i <= n; i++) {
            digit += Math.log10(i);
        }
        return (int) (digit + 1);
    }

    /**
     * 使用斯特林公式
     * 思路：log10(n!) = log10(sqrt(2*pi*n)) + n * log10(n/e)
     */
    public static int getDigit2(int n) {
        double pi = Math.PI;// double pi = Math.acos(-1); 反余弦函数 -1为pi
        double e = Math.E;
        return (int) (Math.log10(Math.sqrt(2 * pi * n)) + n * Math.log10(n / e)) + 1;
    }


    public static int get_digit_lib(int N) {
        int digit = (int) (Math.log10(N) + 1);
        return digit;
    }

    /**
     * 循环的方法
     */
    public static int get_digit_loop(int N) {
        int digit = 0;
        do {
            digit++;
        } while ((N /= 10) > 0);
        return digit;
    }

    /**
     * 递归的方法
     */
    public static int get_digit_recursion(int N) {
        int digit = 0;
        digit = N < 10 ? 1 : 1 + get_digit_recursion(N / 10);
        return digit;
    }

}
