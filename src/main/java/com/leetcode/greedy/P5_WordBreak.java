package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/7/30.
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a spaceseparated
 * sequence of one or more dictionary words.
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class P5_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak2(s, dict));
    }

    /**
     * 这题的意思是给出一本词典以及一个字符串，能否切分这个字符串使得每个字串都在字典里面存在。
     * 假设dp(i)表示长度为i的字串能否别切分，dp方程如下:
     * dp(i) = dp(j) && s[j, i) in dict, 0
     */
    public static boolean wordBreak2(String s, List<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String substring = s.substring(j, i);
                if (dp[j] && dict.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static boolean wordBreak(String s, List<String> dict) {
        if (s == null || s.length() == 0) return true;
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i + 1));
            for (int j = 0; j <= i; j++) {
                if (res[j] && dict.contains(str.toString())) {
                    res[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
}
