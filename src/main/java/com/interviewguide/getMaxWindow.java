package com.interviewguide;

import java.util.LinkedList;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/6.
 * 题目：生成窗口最大值数组
 * 有一个整形数组arr和一个大小为w的窗口从数组的最边边滑动到最右边，窗口每次向右滑动一个位置。
 * 例如，数组[4,3,5,4,3,3,6,7],窗口大小为3时，产生的每一种窗口下的最大值数组为[5,5,5,4,6,7]
 */
public class getMaxWindow {
    public static void main(String[] args) {
        int[] a = {4,3,5,4,3,3,6,7};
        int[] maxWindow = getMaxWindow(a, 3);
        printf(maxWindow);
    }

    public static int[]  getMaxWindow(int[] arr,int w){
        if(arr == null || w<1 || arr.length < w)return null;
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0 ;
        for(int i = 0 ; i <arr.length;i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                // 当遍历到的下标的值大于或者等于qmax中最右边的值，则弹出qmax中最右边的值。
                // 因为在一个窗口内，小的值的可以直接淘汰，相当的话，淘汰老的值
                qmax.pollLast();
            }
            qmax.addLast(i);// 每一个值都会插入到qmax的最右边

            if(qmax.peekFirst() == i-w)// 如果qmax中最左边的下标等于过期下标则弹出
                qmax.pollFirst();
            if(i>= w -1)// 从w-1的位置开始记录最大值的下标
                res[index++] =arr[qmax.peekFirst()]; // 最大值的下标在最左边
        }
        return res;
    }
}
