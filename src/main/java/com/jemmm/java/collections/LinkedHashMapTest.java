package com.jemmm.java.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lMap = new LinkedHashMap<>(2, 0.3f, true);

        for (int i = 0; i < 10; i++) {
            lMap.put(i, "@" + i);
        }
        System.out.println("**** 初始顺序：****");
        for (Map.Entry<Integer, String> entry : lMap.entrySet()) {
            String value = entry.getValue();
            System.out.printf("%-5s", value);
        }

        // 依次访问8，1，4，7，3
        lMap.get(8);
        lMap.get(1);
        lMap.get(4);
        lMap.get(7);
        lMap.get(3);

        System.out.println("\n\n**** 访问过后的顺序：****");
        for (Map.Entry<Integer, String> entry : lMap.entrySet()) {
            String value = entry.getValue();
            System.out.printf("%-5s", value);
        }

        // put 新值
        lMap.put(11, "@" + 11);
        lMap.put(12, "@" + 12);
        lMap.put(13, "@" + 13);
        System.out.println("\n\n**** 插入新k-v后的顺序：****");
        for (Map.Entry<Integer, String> entry : lMap.entrySet()) {
            String value = entry.getValue();
            System.out.printf("%-5s", value);
        }

        // put 旧值
        lMap.put(0, "new" + 0);
        lMap.put(2, "new" + 2);
        lMap.put(4, "new" + 4);

        System.out.println("\n\n**** 插入旧k后的顺序：****");
        for (Map.Entry<Integer, String> entry : lMap.entrySet()) {
            String value = entry.getValue();
            System.out.printf("%-5s", value);
        }

    }
}
