package com.global.advanced.java.advancedjava.java.multithread.threads;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
    private BlockingQueue<Runnable> runnableQueue = new ArrayBlockingQueue<>(1_000);

    public MyThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            MyExecutorThread executorThreadLoc = new MyExecutorThread(this);
            executorThreadLoc.setName("MyExecutor-" + i);
            executorThreadLoc.start();
        }
    }

    public void execute(Runnable runnableParam) {
        runnableQueue.add(runnableParam);
    }


    private static class MyExecutorThread extends Thread {
        private MyThreadPool myThreadPool;

        public MyExecutorThread(final MyThreadPool myThreadPoolParam) {
            myThreadPool = myThreadPoolParam;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Runnable taskLoc = myThreadPool.runnableQueue.take();
                    taskLoc.run();
                    if (isInterrupted()){
                        return;
                    }
                } catch (InterruptedException eParam){
                    return;
                } catch (Exception eParam) {
                    if (isInterrupted()){
                        return;
                    }
                    eParam.printStackTrace();
                }
            }
        }
    }

}
