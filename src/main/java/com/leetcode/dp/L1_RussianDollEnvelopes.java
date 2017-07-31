package com.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/30.
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]],
 * the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 俄罗斯套娃问题
 */
public class L1_RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] a = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        printf(maxEnvelopes(a));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });

        int dp[] = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) index = -index - 1;
            dp[index] = envelope[1];
            if (index == len) len++;
        }
        return len;
    }

}
