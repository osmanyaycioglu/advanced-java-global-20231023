package com.global.advanced.java.advancedjava.java.streams;

import com.global.advanced.java.advancedjava.models.Customer;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams4 {
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

        Map<String, Customer> collectLoc = names.stream()
                                                .distinct()
                                                .filter(s -> s.length() > 4)
                                                .collect(Collectors.toMap(s -> s,
                                                                          s -> Customer.builder()
                                                                                       .withFirstName(s)
                                                                                       .build()));


        Collector<CharSequence, StringBuilder, String> strCollector = new Collector<CharSequence, StringBuilder, String>() {


            @Override
            public Supplier<StringBuilder> supplier() {
                return () -> {
                    return new StringBuilder().append("Toparlanan data : ");
                };
            }

            @Override
            public BiConsumer<StringBuilder, CharSequence> accumulator() {
                return (st, s1) -> {
                    st.append("-").append(s1);
                };
            }

            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return (s1, s2) -> {
                    s1.append(s2);
                    return s1;
                };
            }

            @Override
            public Function<StringBuilder, String> finisher() {
                return s -> {
                    return s.toString();
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();

            }
        };

        String collectLoc1 = names.stream()
                                  .distinct()
                                  .filter(s -> s.length() > 4)
                                  .collect(strCollector);
        System.out.println(collectLoc1);
    }
}
