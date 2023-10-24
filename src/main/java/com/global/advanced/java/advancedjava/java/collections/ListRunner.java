package com.global.advanced.java.advancedjava.java.collections;

import com.global.advanced.java.advancedjava.models.Customer;

import java.util.*;

public class ListRunner {
    private List<Customer> customers  = new Vector<>(); // Thread safe
    private List<Customer> customers2 = Collections.synchronizedList(new ArrayList<>()); // Thread safe


    public static void main(String[] args) {
        List<String> stringListLoc  = new ArrayList<>();
        List<String> stringListLoc2 = new LinkedList<>();
        // ekleme
        stringListLoc.add("osman");
        stringListLoc.add("osman");
        stringListLoc.add("ali");
        stringListLoc.add("ayşe");
        stringListLoc.add("test");
        stringListLoc.add("mehmet");

        stringListLoc.forEach(str -> System.out.println("Liste : " + str));
        // alma
        String stringLoc = stringListLoc.get(0);
        // çıkarma
        stringListLoc.remove(3);
        // arama
        boolean testLoc = stringListLoc.contains("test");
        //gezme
        // 1
        for (int i = 0; i < stringLoc.length(); i++) {
            String stringLoc1 = stringListLoc.get(i);
            System.out.println(stringLoc1);
        }
        // 2
        for (String sLoc : stringListLoc) {
            System.out.println(sLoc);
        }
        // 3
        Iterator<String> iteratorLoc = stringListLoc.iterator();
        while (iteratorLoc.hasNext()) {
            String nextLoc = iteratorLoc.next();
            System.out.println(nextLoc);
        }
        // 4
        stringListLoc.forEach(System.out::println);

    }
}
