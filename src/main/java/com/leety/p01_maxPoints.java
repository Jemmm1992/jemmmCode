package com.leety;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BIG-JIAN on 2017/9/15.
 */
public class p01_maxPoints {
    public static void main(String[] args) {

    }

    public static int maxPoints(Point[] points) {
        int n = points.length;
        if (n < 2) return n;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            // 分别统计与点i重合以及垂直的点的个数
            int dup = 1, vtl = 0;
            Map<Float, Integer> map = new HashMap<>();

            Point a = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                Point b = points[j];
                if (a.x == b.x) {
                    if (a.y == b.y) dup++;
                    else vtl++;
                } else {
                    float k = (float) (a.y - b.y) / (a.x - b.x);
                    if (map.get(k) == null) map.put(k, 1);
                    else map.put(k, map.get(k) + 1);
                }
            }
            int max = vtl;
            for (float k : map.keySet()) {
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret, max + dup);
        }
        return ret;
    }
}


class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
