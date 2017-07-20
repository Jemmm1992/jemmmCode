package com.jemmm.java.thread;

/**
 * Created by BIG-JIAN on 2017/7/19.
 */

/**
 * 主线程运行
 * 主线程等待
 * 主线程继续->等待耗时：3009ms
 * <p>
 * 分析：在waitAndNotifyAll()中，会启动一个WaitThread线程，在该线程中将会调用sleep函数睡眠3秒。
 * 线程启动之后在主线程调用sLockObject的wait函数，使主线程进入等待状态。等waitThread睡眠3秒后会调用
 * sLockObject的notifyAll函数，就会唤醒正在等待中的主线程。
 * <p>
 * wait()。当一个线程执行wait方法时，它就进入到一个和该对象相关的等待池中，同时释放了对象的锁，适其他线程可以访问。
 * 用户可以使用notify或者notifyAll函数或者指定睡眠时间来唤醒当前等待池中的线程。
 * <p>
 * wait和notify机制通常用来等待机制的实现，当条件没有满足的时候调用wait进入等待状态，一旦满足，调用notify或者notifyAll唤醒
 * 等待的线程继续执行。
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        waitAndNotifyAll();
    }

    private static Object sLockObject = new Object();

    static void waitAndNotifyAll() {
        System.out.println("主线程运行");
        Thread thread = new WatiThread();
        thread.start();
        long begin = System.currentTimeMillis();
        try {
            synchronized (sLockObject) {
                System.out.println("主线程等待");
                sLockObject.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - begin;
        System.out.println("主线程继续->等待耗时：" + time + "ms");
    }

    static class WatiThread extends Thread {
        @Override
        public void run() {
            synchronized (sLockObject) {
                try {
                    Thread.sleep(3000);
                    sLockObject.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
