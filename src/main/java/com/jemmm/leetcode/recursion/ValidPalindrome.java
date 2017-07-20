package com.jemmm.leetcode.recursion;

/**
 * Created by BIG-JIAN on 2017/7/4.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama"is a palindrome.
 * "race a car"is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String ss = "race a car";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
        System.out.println(!Character.isAlphabetic('!'));
    }
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j && i < s.length() && j >= 0) {
            while (i < j && (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)))) i++;
            while (i < j && (!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j)))) j--;
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * 如果不使用Character#isAlphabetic和#isDigit，可以自己实现一个判断器
     */
    public static boolean isValid(char c){
        if(c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9')
            return true;
        return false;
    }

}
