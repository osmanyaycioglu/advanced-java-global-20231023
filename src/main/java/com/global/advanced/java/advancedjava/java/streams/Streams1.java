package com.global.advanced.java.advancedjava.java.streams;

import com.global.advanced.java.advancedjava.models.Customer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Streams1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("osman",
                                           "ali",
                                           "taylan",
                                           "hatice",
                                           "mehmet",
                                           "mahmut",
                                           "taylan",
                                           "hatice",
                                           "ali",
                                           "mehmet",
                                           "ayşe",
                                           "ali",
                                           "mehmet",
                                           "taylan",
                                           "hatice",
                                           "tugay");

        Map<Long, Customer> mapLoc     = new HashMap<>();
        AtomicLong          counterLoc = new AtomicLong();
        List<Customer> collectLoc = names.stream()
                                         .limit(20)
                                         .peek(s -> System.out.println("Before Skip : " + s + " thread : " + Thread.currentThread().getName()))
                                         .skip(2)
                                         .peek(s -> System.out.println("Before Distinct : " + s+ " thread : " + Thread.currentThread().getName()))
                                         .distinct()
                                         .parallel()
                                         .peek(s -> System.out.println("Filter 4 : " + s+ " thread : " + Thread.currentThread().getName()))
                                         .filter(s -> s.length() > 4)
                                         .peek(s -> System.out.println("Filter a : " + s+ " thread : " + Thread.currentThread().getName()))
                                         .filter(s -> s.contains("a"))
                                         .peek(s -> System.out.println("Collect : " + s+ " thread : " + Thread.currentThread().getName()))
                                         .map(s -> Customer.builder()
                                                           .withFirstName(s)
                                                           .build())
                                         .peek(c -> c.setHeight(200))
                                         .peek(c -> mapLoc.put(counterLoc.incrementAndGet(),
                                                               c))
                                         .collect(Collectors.toList());
        System.out.println(collectLoc);
        System.out.println("--------------------");
        System.out.println(mapLoc);
    }
}
