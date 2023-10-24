package com.global.advanced.java.advancedjava.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListBench {
    // 1s -> 1000ms -> 1.000.000  micros -> 1.000.000.000 ns
    // JIT -> Just in time compilation

    public static void main(String[] args) {
        //List<String> stringListLoc = new LinkedList<>();
        List<String> stringListLoc = new ArrayList<>();
        stringListLoc.add("osman");

        for (int i = 0; i < 1_000_000; i++) {
            stringListLoc.add("osman");
        }
        // execute garbage collection
        System.gc();
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException eParam) {
        }

        List<String> sList = new ArrayList<>(1_200_000);
        // List<String> sList = new LinkedList<>();
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            sList.add("osman" + i);
        }
        System.out.println("add delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            String stringLoc = sList.get(i);
        }
        System.out.println("get delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 100_000; i < 110_000; i++) {
            boolean containsLoc = sList.contains("osman" + i);
        }
        System.out.println("contains delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String stringLoc : sList) {

        }
        System.out.println("iterate delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            String stringLoc = sList.remove(50_000);
        }
        System.out.println("remove delta : " + (System.currentTimeMillis() - delta));

        // List lerde kullanma
        // sList.removeAll(null);
        // sList.retainAll(null);
        // sList.containsAll(null);

        // List lerde kullanabilirsin
        sList.addAll(Arrays.asList("deneme","mehmet","ali"));
    }
}
