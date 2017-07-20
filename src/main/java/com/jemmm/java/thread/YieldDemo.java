package com.jemmm.java.thread;

/**
 * Created by BIG-JIAN on 2017/7/19.
 * yield：调用该函数的线程让出执行时间给其他已就绪状态的线程。
 * yield主动让出线程的执行权给其他线程，但是前提是这些线程的优先级要等于或者大于调用yield的线程。
 *
 * 通常情况下，t1先执行，当执行到2的时候，让出线程的执行时间，所以从第4行开始是t2执行，此时当t2执行到
 * 2的时候，t2让出执行权。（因为ti和t2的优先级一样，所以虽然t2让出执行权，但是仍然可以竞争执行权，继续执行）
 */
public class YieldDemo {
    public static void main(String[] args) {
        YieldThread t1 = new YieldThread("thread-1");
        YieldThread t2 = new YieldThread("thread-2");
        t1.start();
        t2.start();
    }

    static class YieldThread extends Thread {
        public YieldThread(String name) {
            super(name);
        }

        public synchronized void run() {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s[%d]---->%d\n", this.getName(), this.getPriority(), i);
                // 当i为2的时候，调用当前相城yield函数
                if (i == 2) {
                    Thread.yield();
                }
            }
        }
    }
}

//thread-1[5]---->0
//        thread-1[5]---->1
//        thread-1[5]---->2
//        thread-2[5]---->0
//        thread-2[5]---->1
//        thread-2[5]---->2
//        thread-2[5]---->3
//        thread-2[5]---->4
//        thread-1[5]---->3
//        thread-1[5]---->4

