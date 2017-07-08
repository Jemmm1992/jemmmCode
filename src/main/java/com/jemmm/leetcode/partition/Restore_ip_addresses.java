package com.jemmm.leetcode.partition;

/**
 * Created by BIG-JIAN on 2017/6/18.
 */

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given"25525511135",
 * return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 思路：
 */
public class Restore_ip_addresses {
    public static void main(String[] strs) {
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1110000"));
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }

        StringBuilder tmp = new StringBuilder();

        depthFS(0, 0, s, tmp, res);

        return res;
    }

    public static void depthFS(int count, int index, String s, StringBuilder tmp, ArrayList<String> res) {
        if (count == 4 && index == s.length()) {
            res.add(tmp.toString().substring(0, tmp.length() - 1));
            return;
        } else {
            for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
                String tmpStr = s.substring(index, index + i);
                if (isValid(tmpStr)) {
                    int bt = tmp.length();
                    int ed = tmp.length() + tmpStr.length();
                    tmp.append(tmpStr).append(".");
                    depthFS(count + 1, index + i, s, tmp, res);
                    tmp.delete(bt, ed + 1);
                }
            }
        }
    }

    public static boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }

        int num = Integer.parseInt(s);

        return num > 0 && num <= 255;
    }
}
