package com.zhenti.ALIBABA;

/**
 * Created by BIG-JIAN on 2017/8/6.
 */
public class Main {

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        boolean b = true;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (ss[si] != ms[mi] && b == true) {
                si++;
                mi++;
                b = false;
            } else if (next[mi] == -1) {
                si++;
                b = true;
            } else {
                mi = next[mi];
                b = true;
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "xx_drese_dress_dresw_search";
//        String match = "glass";
        String match = "drese";
        boolean b = false;
        int len = 0;
        while (str.length() != 0) {
            int indexOf = getIndexOf(str, match);
            if (indexOf != -1) {
                b = true;
                System.out.printf(len + indexOf + " ");
                len = indexOf + match.length() + len;
                if (indexOf + match.length() <= str.length()) {
                    str = str.substring(indexOf + match.length(), str.length());
                }
            } else {
                break;
            }
        }
        if (!b) System.out.println(-1);
    }
}
