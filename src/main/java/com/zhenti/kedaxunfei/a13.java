package com.zhenti.kedaxunfei;

import java.util.*;

/**
 * Created by BIG-JIAN on 2017/9/16.
 */
public class a13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.valueOf(sc.nextLine());
            TreeMap<String, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                map.put(sc.nextLine(), 0);
            }
            String[] s = new String[n * (n - 1) / 2];
            for (int i = 0; i < n * (n - 1) / 2; i++) {
                s[i] = sc.nextLine();
                get(s[i], map);
            }
            System.out.println(map);

        }
    }

    public static void get(String s, TreeMap<String, Integer> map) {
        String[] s1 = s.split(" ");
        String[] s2 = s1[0].split("-");
        String[] s3 = s1[1].split(":");
        if (s3[0].compareTo(s3[1]) == 1) {
            map.put(s2[0], map.get(s2[0]) + 3);
        } else if (s3[0].compareTo(s3[1]) == -1) {
            map.put(s2[1], map.get(s2[0]) + 3);
        } else if (s3[0].compareTo(s3[1]) == 0) {
            map.put(s2[0], map.get(s2[0]) + 1);
            map.put(s2[1], map.get(s2[0]) + 1);
        }
    }
}
//4
//A
//B
//C
//D
//A-B 1:1
//A-C 2:2
//A-D 1:0
//B-C 1:0
//B-D 0:3
//C-D 0:3