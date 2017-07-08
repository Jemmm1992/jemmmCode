package com.jemmm.java.collections;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by BIG-JIAN on 2017/7/8.
 */
public class BlockIngQueueTest {
    public static void main(String args[]) {
        try {
            LinkedBlockingQueue<String> queue = new LinkedBlockingQueue(2);

            boolean bol1 = queue.offer("hello");
            boolean bol2 = queue.offer("world");
            boolean bol3 = queue.add("yes");
            // queue.put("yes");

            System.out.println(queue.toString());
            System.out.println(bol1);
            System.out.println(bol2);
            // System.out.println(bol3);
        } catch (Exception e) {
            System.out.println("我是异常: " + e);
        }
    }
}
