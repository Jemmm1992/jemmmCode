package com.zhenti.meituan; /**
 * Created by BIG-JIAN on 2017/9/14.
 */

import java.util.*;

public class a4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[7][7];
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            System.out.println(tmp + " " + getTens(tmp));
            arr[tmp % 7][getTens(tmp) % 7]++;
        }
        int result = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                for (int k = 0; k < 7; k++) {
                    if (arr[i][j] > 0 && (i + j * k) % 7 == 0) {
                        int sum = 0;
                        for (int m = 0; m < 7; m++) {
                            sum += arr[k][m];
                        }
                        if (k == i) {
                            sum--;
                        }
                        result += arr[i][j] * sum;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static int getTens(int num) {
        int sum = 1;
        while ((num /= 10) != 0) {
            sum++;
        }
        return (int) Math.pow(3, sum);
    }
}

