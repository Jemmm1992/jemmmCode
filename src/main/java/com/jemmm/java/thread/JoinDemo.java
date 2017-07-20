package com.jemmm.java.thread;

/**
 * Created by BIG-JIAN on 2017/7/19.
 *
 启动线程1
 work in work-1
 启动线程2
 work in work-2
 主线程继续执行
 */

/**
 * 解析：在joinDemo中，首先创建了两个子线程，然后启动了worker1，下一步再调用join函数。
 * 此时，主线程进入阻塞状态，一直到worker1执行完毕之后才开始继续执行。
 * 因为worker的run函数会睡眠3秒，因此，在主线程中每次调用join实际上都会阻塞3秒，知道run执行完毕后再继续。
 *
 * join的含义：阻塞当前调用join函数的线程 直到worker执行完毕之后再继续。
 */
public class JoinDemo {
    public static void main(String[] args) {
        Worker worker1 = new Worker("work-1");
        Worker worker2 = new Worker("work-2");
        try {
            System.out.println("启动线程1");
            worker1.start();
            // 调用worker1的join函数，主线程会阻塞知道work1执行完成
            worker1.join();
            System.out.println("启动线程2");
            worker2.start();
            worker2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程继续执行");
    }

    static   class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("work in " + getName());
        }
    }

}
