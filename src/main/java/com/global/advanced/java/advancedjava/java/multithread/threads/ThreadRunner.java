package com.global.advanced.java.advancedjava.java.multithread.threads;

import java.util.concurrent.*;

public class ThreadRunner {

    public static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        CountDownLatch countDownLatchLoc = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            MyFirstThread myFirstThreadLoc = new MyFirstThread("MFT-" + i,
                                                               countDownLatchLoc);
            myFirstThreadLoc.start();
        }
        try {
            countDownLatchLoc.await();
        } catch (InterruptedException eParam) {
        }

        System.out.println("Counter : " + MyFirstThread.counter);
        System.out.println("CounterAtomic : " + MyFirstThread.counterAtomic.get());
        System.out.println("CounterLock : " + MyFirstThread.counterLock);

        Runnable runnableLoc = () -> System.out.println("çalıştım");
        Thread   threadLoc   = new Thread(runnableLoc);
        threadLoc.start();

        ExecutorService executorServiceLoc = Executors.newFixedThreadPool(10);
        executorServiceLoc.execute(() -> System.out.println("Thread pool task 1"));
        executorServiceLoc.execute(() -> System.out.println("Thread pool task 2"));
        executorServiceLoc.execute(() -> System.out.println("Thread pool task 3"));
        executorServiceLoc.execute(() -> System.out.println("Thread pool task 4"));
        executorServiceLoc.execute(() -> System.out.println("Thread pool task 5"));
        executorServiceLoc.execute(() -> System.out.println("Thread pool task 6"));


        MyThreadPool myThreadPoolLoc = new MyThreadPool(20);
        for (int i = 0; i < 10; i++) {
            myThreadPoolLoc.execute(() -> System.out.println("Thread pool task " + Thread.currentThread()
                                                                                         .getName()));
        }

        Callable<String> stringCallableLoc = () -> {
            Thread.sleep(3_000);
            return "Test call";
        };

        Future<String> submitLoc = executorServiceLoc.submit(stringCallableLoc);
        System.out.println("Line after future 1");
        System.out.println("Line after future 2");
        System.out.println("Line after future 3");
        System.out.println("Line after future 4");
        System.out.println("Line after future 5");
        String stringLoc = null;
        try {
            submitLoc.isDone();

            stringLoc = submitLoc.get();
            System.out.println("Cevap : " + stringLoc);
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        } catch (ExecutionException eParam) {
            throw new RuntimeException(eParam);
        }



    }
}
