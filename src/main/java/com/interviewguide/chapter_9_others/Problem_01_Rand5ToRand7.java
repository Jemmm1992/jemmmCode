package com.interviewguide.chapter_9_others;

/**
 * Created by BIG-JIAN on 2017/9/6.
 */
public class Problem_01_Rand5ToRand7 {
    /**
     * 随机产生1~5
     */
    public static int randTo5() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 利用randTo5()随机产生7
     */
    public static int randTo7() {
        int num = 0;
        do {
            num = 5 * (randTo5() - 1) + randTo5() - 1;
        } while (num > 20);
        return num % 7 + 1;
    }



    public static void main(String[] args) {
        int testTimes = 1000000;
        int[] countArr1 = new int[6];
        for (int i = 0; i != testTimes; i++) {
            countArr1[randTo5()]++;
        }
        printfArrayCount(countArr1);
    }

    public static void printfArrayCount(int[] a) {
        for (int i = 1; i < a.length; i++) {
            System.out.println(i + "appears" + a[i] + "times");
        }
    }
}
