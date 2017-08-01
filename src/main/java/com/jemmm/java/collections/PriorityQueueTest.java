package com.jemmm.java.collections;

import java.util.PriorityQueue;

import static com.utils.PrintfUtils.printf;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        HeapPractice();
    }

    public static void HeapPractice() {
        printf("HeapPractice() enter");
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> (o2 - o1));// 添加比较器
        heap.add(10);
        heap.add(2);
        heap.add(60);
        heap.add(18);
        heap.add(9);
        heap.add(99);
        heap.add(90);
        heap.add(7);
		/*
		 * peek top1 element:2 remaining elements in heap: [2, 7, 60, 9, 10, 99,
		 * 90, 18] peek top2 element:7 remaining elements in heap: [7, 9, 60,
		 * 18, 10, 99, 90]
		 */
        printf("peek top1 element:" + heap.peek());
        printf("remaining elements in heap: " + heap);
        heap.remove(heap.peek());
        printf("peek top2 element:" + heap.peek());
        printf("remaining elements in heap: " + heap);
        for (Integer integer : heap) {
            System.out.print(integer + " ");
        }
        while (!heap.isEmpty()) {
            System.out.print(heap.peek() + " ");
            heap.remove(heap.peek());
        }
        return;
    }
}
