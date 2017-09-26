package com.zhenti.dajiang;

import java.util.Scanner;

public class tet33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double H = sc.nextInt();
        double x = sc.nextInt();
        double y = sc.nextInt();
        double h = sc.nextInt();
        double s = sc.nextInt();
        if (s <= h / x) {
            System.out.println(Math.round(x * s));
        } else if (s > h / x && x == y) {
            System.out.println(h);
        } else if (s > h / x && x != y && s < h / x + (H - h) / (x - y)) {
            System.out.println(Math.round(h + (s - h / x) * (x - y)));
        } else if (s >= h / x + (H - h) / (x - y)) {
            System.out.println(Math.round(H));
        }
    }
}
//10 2 1 1 5
//10 2 1 3 1