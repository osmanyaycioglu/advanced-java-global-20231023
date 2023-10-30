package com.global.advanced.java.advancedjava.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String>         stringsLoc             = new ArrayBlockingQueue<>(1_000);
        BlockingQueue<String> stringBlockingQueueLoc = new ArrayBlockingQueue<>(1_000);
        Queue<String>         stringsLinkedLoc       = new LinkedList<>();

        Deque<String>         stringDequeLoc   = new ArrayDeque<>();
        BlockingDeque<String> blockingDequeLoc = new LinkedBlockingDeque<>();

        stringsLoc.add("osman");
        boolean aliLoc = stringsLoc.offer("ali");

        String pollLoc1 = stringsLoc.poll();
        String pollLoc2 = stringsLoc.poll();
        String pollLoc3 = stringsLoc.poll();

        stringBlockingQueueLoc.add("osman");
        boolean aliLoc1 = stringBlockingQueueLoc.offer("ali");

        try {
            String takeLoc1 = stringBlockingQueueLoc.take();
            System.out.println("take 1 : " + takeLoc1);
            String takeLoc2 = stringBlockingQueueLoc.take();
            System.out.println("take 2 : " + takeLoc2);
            String takeLoc3 = stringBlockingQueueLoc.poll(2, TimeUnit.SECONDS);
            System.out.println("take 3 : " + takeLoc3);
            System.out.println("Buradayım");
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        }

        stringDequeLoc.addLast("osman1");
        stringDequeLoc.addFirst("osman2");
        stringDequeLoc.pollFirst();
        stringDequeLoc.pollLast();




    }

}
