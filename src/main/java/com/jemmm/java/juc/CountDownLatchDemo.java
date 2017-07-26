package com.jemmm.java.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/**
 * Created by BIG-JIAN on 2017/7/23.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 20;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                long l = System.currentTimeMillis();
                System.out.println(Thread.currentThread() + "--start:--->" + l);
                fibc(40);
                System.out.println(Thread.currentThread() + "--end:--->" + (System.currentTimeMillis() - l));
            }
        };
        long l = timeTasks(nThreads, task);
        System.out.println("总的花费时间: " + l);
        System.out.println(fibc(25));
    }

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.currentTimeMillis();
        System.out.println("start: ");
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        System.out.println("end ");
        return end - start;
    }

    // 效率低下的斐波那契数列，其实耗时的操作
    private static int fibc(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return fibc(num - 1) + fibc(num - 2);
    }
}
