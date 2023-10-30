package com.global.advanced.java.advancedjava.java.streams;

import com.global.advanced.java.advancedjava.models.Customer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams5 {
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

        Stream<Stream<Character>> streamStreamLoc = names.stream()
                                                         .distinct()
                                                         .map(s -> {
                                                             char[]      charsLoc      = s.toCharArray();
                                                             Character[] charactersLoc = new Character[charsLoc.length];
                                                             for (int i = 0; i < charsLoc.length; i++) {
                                                                 charactersLoc[i] = charsLoc[i];
                                                             }
                                                             return Arrays.stream(charactersLoc);
                                                         });
        List<Character> collectLoc = names.stream()
                                          .distinct()
                                          .flatMap(s -> {
                                              char[]      charsLoc      = s.toCharArray();
                                              Character[] charactersLoc = new Character[charsLoc.length];
                                              for (int i = 0; i < charsLoc.length; i++) {
                                                  charactersLoc[i] = charsLoc[i];
                                              }
                                              return Arrays.stream(charactersLoc);
                                          })
                                          .distinct()
                                          .sorted()
                                          .collect(Collectors.toList());

        System.out.println(collectLoc);

    }
}
