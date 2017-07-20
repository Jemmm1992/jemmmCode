package com.jemmm.prototype;

import java.util.Random;

import static com.jemmm.utils.CommonUtils.swap;

/**
 * Created by BIG-JIAN on 2017/7/8.
 * 随机生成1到100的数
 */
public class Random1To100 {
    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            createRandom4();
            System.out.println();
        }
    }

    private static void createRandom4() {
        Random random = new Random();
        int value = 10;
        int[] list = new int[value];
        for (int j = 0; j < value; ++j) {
            list[j] = j + 1;
        }

        int index = 0;
        int count = 0;
        while (value > 0) {
            index = random.nextInt(value);
            swap(list, count + index, count);
            ++count;
            --value;
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }

}
