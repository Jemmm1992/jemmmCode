package com.jemmm.java.thread;

import java.util.concurrent.*;

/**
 * Created by BIG-JIAN on 2017/7/19.
 */
public class FutureDemo {
    static ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureWithRunnable();
        futureWithCallable();
        futureTask();
    }

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            fibc(20);
        }
    };

    private static void futureWithRunnable() throws ExecutionException, InterruptedException {

        Future<?> result = mExecutor.submit(runnable);
        System.out.println("future result from runnable : " + result.get());
    }

    //    // 提交Callable对象，有返回值
//    private static void futureWithCallable() throws ExecutionException, InterruptedException {
//        Future<Integer> result2 = mExecutor.submit(() -> {return fibc(20);});
//        System.out.println("future result from Callable : " + result2.get());
//    }
    // 提交Callable对象，有返回值
    private static void futureWithCallable() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fibc(20);
            }
        };
        Future<Integer> result2 = mExecutor.submit(callable);
        System.out.println("future result from Callable : " + result2.get());
    }

    private static void futureTask() throws ExecutionException, InterruptedException {
        //提交FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(
                new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return fibc(20);
                    }
                }
        );
         mExecutor.submit(futureTask);
        System.out.println("future result from futureTask : " + futureTask.get());
    }


    // 效率低下的斐波那契数列，其实耗时的操作
    private static int fibc(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return fibc(num - 1) + fibc(num - 2);
    }
}
