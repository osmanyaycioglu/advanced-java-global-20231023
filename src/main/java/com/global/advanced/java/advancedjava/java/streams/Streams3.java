package com.global.advanced.java.advancedjava.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Streams3 {
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

        String reduceLoc = names.stream()
                                .distinct()
                                .filter(s -> s.length() > 4)
                                .reduce("",
                                        (sa, s1) -> {
                                            if (sa.isEmpty()) {
                                                return s1;
                                            }
                                            return sa + "-" + s1;
                                        },
                                        (s1, s2) -> s1 + "-" + s2);
        System.out.println(reduceLoc);
        ArrayList<String> reduceLoc1 = names.stream()
                                            .distinct()
                                            .filter(s -> s.length() > 4)
                                            .reduce(new ArrayList<String>(),
                                                    (lst, str) -> {
                                                        lst.add(str);
                                                        return lst;
                                                    },
                                                    (lst1, lst2) -> {
                                                        lst1.addAll(lst2);
                                                        return lst2;
                                                    });
        System.out.println(reduceLoc1);
    }
}
