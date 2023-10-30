package com.global.advanced.java.advancedjava.java.multithread.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class MyFirstThread extends Thread {
    private       String        name;
    public static long          counter       = 0;
    public static AtomicLong    counterAtomic = new AtomicLong();
    public static long          counterLock   = 0;
    public static ReentrantLock lock          = new ReentrantLock();
    private CountDownLatch countDownLatch;

    public static void increase() {
        synchronized (MyFirstThread.class) {
            counter++;
        }
    }

    public void increaseClass() {
        synchronized (this) {
            counter++;
        }
    }

    public void checkClass() {
        synchronized (this) {
            System.out.println(counter);
        }
    }


    public static void increaseWithLock() {
        lock.lock();
        try {
            counterLock++;
        } finally {
            lock.unlock();
        }
    }

    public MyFirstThread(final String nameParam,
                         final CountDownLatch countDownLatchParam) {
        name           = nameParam;
        countDownLatch = countDownLatchParam;
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            increaseClass();
            counterAtomic.incrementAndGet();
            increaseWithLock();
        }
        countDownLatch.countDown();
    }
}
