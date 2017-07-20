package com.jemmm.prototype;

import java.util.BitSet;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
/*
* 筛选法求素数
<1> 先将1挖掉(因为1不是素数)。
<2> 用2去除它后面的各个数，把能被2整除的数挖掉，即把2的倍数挖掉。
<3> 用3去除它后面的各数，把3的倍数挖掉。
<4> 分别用4、5…各数作为除数去除这些数以后的各数。这个过程一直进行到在除数后面的数已全被挖掉为止。
如果需要找1～n范围内素数表，只需进行到除数为n^2(根号n)，取其整数即可。
*/

public class PrimeScreening {
    public static void main(String[] args) {

        System.out.print("请输入一个整数x:");
        int x = 10;
        get1(10);
        System.out.println();
        get2(20);
    }

    public static void get1(int x) {

        boolean data[] = new boolean[x];

        for (int i = 2; i < data.length; i++)
            data[i] = true;

        int m = (int) Math.sqrt(x);
        for (int j = 0; j < m; j++) {
            if (data[j]) {
                for (int k = 2 * j; k < x; k += j) {
                    data[k] = false;
                }
            }
        }

        System.out.println("利用Eratosthenes方法生成0--x之间的素数:");
        int col = 0;
        for (int k = 2; k < x; k++) {
            if (data[k]) {
                System.out.print(k);
                System.out.print(++col % 7 == 0 ? "\n" : "\t");
            }
        }
    }

    public static void get2(int x) {
        BitSet bm = new BitSet(x);

        // int size = bm.size();
        // System.out.println(size);
        for (int i = 2; i < x; i++)
            bm.set(i); // 将指定索引处的位设置为 true

        int finalBit = (int) Math.sqrt(x);
        for (int i = 2; i < finalBit; i++) {
            if (bm.get(i)) { // 返回指定索引处的位值
                for (int j = 2 * i; j < x; j += i)
                    bm.clear(j); // 将索引指定处的位设置为 false
            }
        }

        System.out.println("利用Eratosthenes方法生成0--x之间的素数:");
        int col = 0;
        for (int k = 2; k < x; k++) {
            if (bm.get(k)) {
                System.out.print(k);
                System.out.print(++col % 7 == 0 ? "\n" : "\t");
            }
        }
    }
}
