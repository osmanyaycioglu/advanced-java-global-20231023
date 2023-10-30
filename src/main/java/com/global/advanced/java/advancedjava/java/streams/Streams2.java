package com.global.advanced.java.advancedjava.java.streams;

import com.global.advanced.java.advancedjava.models.Customer;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams2 {
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

        List<String> stringsLoc = new ArrayList<>();
        names.stream()
             .distinct()
             .filter(s -> s.length() > 4)
             .forEach(s -> stringsLoc.add(s));
        System.out.println(stringsLoc);

        System.out.println("--------------------------");

        List<String> stringsLoc2 = new ArrayList<>();
        names.stream()
             .distinct()
             .filter(s -> s.length() > 4)
             .peek(stringsLoc2::add)
             .forEach(s -> System.out.println("Gelen data : " + s));
        System.out.println(stringsLoc2);

        boolean aLoc = names.stream()
                            .distinct()
                            .filter(s -> s.length() > 4)
                            .allMatch(s -> s.contains("a"));

        System.out.println("All match : " + aLoc);


        System.out.println("----------------------------");
        boolean nLoc = names.stream()
                            .distinct()
                            .filter(s -> s.length() > 4)
                            .peek(s -> System.out.println("None match data : " + s))
                            .noneMatch(s -> s.contains("a"));
        System.out.println("None match : " + nLoc);

        System.out.println("----------------------------");
        boolean anyLoc = names.stream()
                              .distinct()
                              .filter(s -> s.length() > 4)
                              .peek(s -> System.out.println("None match data : " + s))
                              .anyMatch(s -> s.contains("t"));
        System.out.println("Any match : " + anyLoc);


        Optional<String> firstLoc = names.stream()
                                         .distinct()
                                         .filter(s -> s.length() > 4)
                                         .peek(s -> System.out.println("None match data : " + s))
                                         .findFirst();
        String stringLoc = firstLoc.orElse("no data");

        if (stringsLoc2 != null && !stringsLoc2.isEmpty()) {

        }

    }
}
