package com.global.advanced.java.advancedjava.java.multithread.threads;

import java.util.concurrent.*;

public class ConcurrentLibRunner {
    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrierLoc = new CyclicBarrier(3);
        cyclicBarrierLoc.await(); // Thread 1
        cyclicBarrierLoc.await(); // Thread 2
        cyclicBarrierLoc.await(); // Thread 3 hepsi çalışır

        CountDownLatch countDownLatchLoc = new CountDownLatch(4);
        countDownLatchLoc.countDown(); // Other threads

        countDownLatchLoc.await(); // this thread waits

        Exchanger<String> stringExchangerLoc = new Exchanger<>();

    }

    public static void semaphore(){
        Semaphore semaphoreLoc = new Semaphore(3);

        try {
            semaphoreLoc.tryAcquire(); // 0 sa thread bekler
            System.out.println("işlem");
        } finally {
            semaphoreLoc.release();
        }

    }
}
