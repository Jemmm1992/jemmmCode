package com.jemmm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BIG-JIAN on 2017/6/18.
 */
public class Utils {
    public static void printf(ArrayList<ArrayList<Integer>> lists){
        for (List<Integer> list: lists) {
            for (Integer i :list) {
                System.out.printf("%5d",i);
            }
            System.out.println();
        }
    }

    public static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
