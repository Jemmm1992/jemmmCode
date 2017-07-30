package com.leetcode.greedy;

import java.util.HashMap;

/**
 * Created by BIG-JIAN on 2017/7/5.
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S ="ADOBECODEBANC"
 * T ="ABC"
 * Minimum window is"BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string"".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

/**
 * 思路：
 * 两个指针，left指向左边窗口，right指向右边窗口。
 * 1.首先使用一个HashMap来存放T中所有的字符，key为字符，value为该字符的频次。
 * 2.right开始从头开始向右遍历，当遍历到所有的T中的字符后，比较minLen，如果比minLen小的话，则记录minStart，即最小窗口的起始位置。
 * 3.当找到一组包含T字符串的窗口时，这时候开始移动left指针，直到移除一个T中的字符停止，然后继续2中的步骤。
 * 参考：http://blog.csdn.net/linhuanmars/article/details/20343903
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String S = "ADOBECODEBANABCC";
        String T = "ABCC";
        String s = minWindow(S, T);
        System.out.println(s);
    }
    public static String minWindow(String S, String T) {
        if(S==null || S.length()==0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<T.length();i++) {
            if(map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            } else {
                map.put(T.charAt(i),1);
            }
        }
        int left = 0;
        int count = 0;
        int minLen = S.length()+1;
        int minStart = 0;
        for(int right=0; right<S.length();right++) {
            char c = S.charAt(right);
            if(map.containsKey(c)) {
                if(map.get(c)>0) {
                    count++;
                }
                map.put(c,map.get(c)-1);
                while(count == T.length()) {
                    if(right-left+1<minLen) {
                        minLen = right-left+1;
                        minStart = left;
                    }
                    char c1 = S.charAt(left);
                    if(map.containsKey(c1)) {
                        if(map.get(c1)>=0) {
                            count--;
                        }
                        map.put(c1, map.get(c1)+1);
                    }
                    left++;
                }
            }
        }
        if(minLen>S.length()) {
            return "";
        }
        return S.substring(minStart,minStart+minLen);
    }
}
