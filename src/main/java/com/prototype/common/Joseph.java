package com.prototype.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
/**
 * 问题描述：
 *已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。从编号为k的人开始报数，数到m的那个人出列；
 *他的下一个人又从1开始报数，数到m的那个人又出列；依此规律重复下去，直到圆桌周围的人全部出列，求最后一个出列人的编号。
 */
public class Joseph {
    public static void main(String[] args) {
        get();
        System.out.println(fun(5, 2));

    }

    public static void get() {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= 500; i++) {
            list.add(i);
        }
        int index = 2;// 第一个报到3的小孩，索引是2
        while (list.size() > 1) {
            list.remove(index);
            index = index - 1;// 移除该位元素后，下次需要从该位开始遍历，故减1
            index = (index + 3) % list.size();
        }
        System.out.println(list.get(0));

    }

    public static int fun(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
            System.out.println(result);
        }
        return result;
    }
}
