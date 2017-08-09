package com.zhenti.wangyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/9.
 * 小易最近在数学课上学习到了集合的概念,集合有三个特征：1.确定性 2.互异性 3.无序性.
 * 小易的老师给了小易这样一个集合：
 * S = { p/q | w ≤ p ≤ x, y ≤ q ≤ z }
 * 需要根据给定的w，x，y，z,求出集合中一共有多少个元素。小易才学习了集合还解决不了这个复杂的问题,需要你来帮助他。
 * 输入描述:
 * 输入包括一行：
 * 一共4个整数分别是w(1 ≤ w ≤ x)，x(1 ≤ x ≤ 100)，y(1 ≤ y ≤ z)，z(1 ≤ z ≤ 100).以空格分隔
 * 输出描述:
 * 输出集合中元素的个数
 * 输入例子1:
 * 1 10 1 1
 * 输出例子1:
 * 10
 */
public class p7_jihe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        HashSet<Float> set = new HashSet<>();
        for (int i = w; i <= x; i++) {
            for (int j = y; j <= z; j++) {
                set.add((float) i / (float) j);
            }
        }
        System.out.println(set.size());
    }
}
