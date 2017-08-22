package com.zhenti.wangyi.qiuzhao2018;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/12.
 */
public class p8_shulie3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int[][] vec = new int[n][k];
        for (int i = 0; i < k; i++) {
            vec[0][i] = 1;
        }
        ArrayList<ArrayList<Integer>> alofal = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            alofal.add(new ArrayList<>());
        }
        for (int m = 0; m < k; m++) {
            for (int p = 0; p < k; p++) {
                if (fit(m + 1, p + 1)) {
                    alofal.get(m).add(p);
                }
            }
        }
        for (int j = 1; j < n; j++) {
            for (int m = 0; m < k; m++) {
                for (int p : alofal.get(m)) {
                    vec[j][m] = vec[j][m] + vec[j - 1][p];
                }
            }
        }
        int result = 0;
        for (int q = 0; q < k; q++) {
            result += vec[n - 1][q];
        }
        return result;
    }

    public static boolean fit(int a, int b) {
        return (a <= b) || (a % b != 0);
    }
}
