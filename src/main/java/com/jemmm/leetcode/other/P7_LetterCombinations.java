package com.jemmm.leetcode.other;

import java.util.ArrayList;

import static com.jemmm.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/25.
 */
public class P7_LetterCombinations {
    public static void main(String[] args) {
        String s = "23";
        ArrayList<String> list = letterCombinations(s);
        printf(list);
    }


    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        res.add("");
        if (digits == null || digits.length() == 0) return res;
        for (int i = 0; i < digits.length(); i++) {
            String letters = getLetters(digits.charAt(i));
            ArrayList<String> newRes = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                for (int k = 0; k < letters.length(); k++) {
                    newRes.add(res.get(j) + Character.toString(letters.charAt(k)));
                }
            }
            res = newRes;
        }
        return res;
    }

    public static ArrayList<String> letterCombinations2(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        res = new ArrayList<>();
        DFS(0, digits, res, new StringBuffer());
        return res;
    }

    /**
     * dfs的解法
     */
    public static void DFS(int start, String digits, ArrayList<String> res, StringBuffer sb) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = getLetters(digits.charAt(start));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            DFS(start + 1, digits, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private static String getLetters(char digit) {
        switch (digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }
}
