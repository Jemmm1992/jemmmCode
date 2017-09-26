package com.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] xa = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xa[i] = x;
            if (map.get(x) == null) {
                map.put(x, y);
            } else {
                if (y > map.get(x))
                    map.put(x, y);
            }
        }
        Arrays.sort(xa);
        int miny = -1;
        for (int i = xa.length - 1; i >= 0; i--) {
            if (map.get(xa[i]) > miny) miny = map.get(xa[i]);
            else map.put(xa[i], null);
        }
        for (int i = 0; i < xa.length; i++) {
            if (map.get(xa[i]) != null) System.out.println(xa[i] + " " + map.get(xa[i]));
        }
    }
}
