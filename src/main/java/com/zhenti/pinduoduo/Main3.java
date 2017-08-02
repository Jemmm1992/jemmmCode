package com.zhenti.pinduoduo;

import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/1.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(mul(str1, str2));
    }

    public static String mul(String str1, String str2) {
        StringBuffer bstr = new StringBuffer();
        int i = 0, j = 0;
        for (i = 0; i < str1.length() + str2.length(); i++) {
            bstr.append('0');
        }
        int k = bstr.length() - 1, add = 0, temp = 0;
        for (j = str2.length() - 1; j >= 0; j--) {
            if (str2.charAt(j) != '0') {
                for (i = str1.length() - 1; i >= 0; i--) {
                    k = i + j + 1;
                    temp = (str2.charAt(j) - '0') * (str1.charAt(i) - '0') + (bstr.charAt(k) - '0');
                    bstr.setCharAt(k--, (char) ('0' + temp % 10));
                    add = temp / 10;
                    while (add != 0) {
                        temp = add + bstr.charAt(k) - '0';
                        bstr.setCharAt(k--, (char) ('0' + temp % 10));
                        add = temp / 10;
                    }
                }
            }
        }
        return bstr.substring(firstNotZeroIndex(bstr));
    }

    private static int firstNotZeroIndex(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) if (str.charAt(i) != '0') return i;
        return str.length() - 1;
    }
}
