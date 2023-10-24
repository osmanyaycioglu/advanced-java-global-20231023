package com.global.advanced.java.advancedjava.java.collections;

import java.util.*;

public class SetBench {
    // 1s -> 1000ms -> 1.000.000  micros -> 1.000.000.000 ns
    // JIT -> Just in time compilation

    public static void main(String[] args) {
        Set<String> stringListLoc = new HashSet<>();
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

        Set<String> sList = new HashSet<>();
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            sList.add("osman" + i);
        }
        System.out.println("add delta : " + (System.currentTimeMillis() - delta));


        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            boolean containsLoc = sList.contains("osman" + i);
        }
        System.out.println("contains delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String stringLoc : sList) {

        }
        System.out.println("iterate delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            sList.remove("osman" + i);
        }
        System.out.println("remove delta : " + (System.currentTimeMillis() - delta));

    }
}
