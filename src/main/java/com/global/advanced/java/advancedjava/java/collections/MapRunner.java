package com.global.advanced.java.advancedjava.java.collections;

import com.global.advanced.java.advancedjava.models.Customer;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapRunner {
    public static void main(String[] args) {
        Map<String, Customer> customerMapLoc = new HashMap<>();

        Map<String, Customer> customerMapThreadSafeLoc = new Hashtable<>();

        Map<String, Customer> customerMapThreadSafeLoc2 = new ConcurrentHashMap<>(1_200_000,
                                                                                  0.9f,
                                                                                  1_200);

        customerMapLoc.put("osman",
                           new Customer("osman",
                                        "yay",
                                        LocalDate.of(1970,
                                                     11,
                                                     11),
                                        90,
                                        200));
        customerMapLoc.put("ali",
                           new Customer("ali",
                                        "veli",
                                        LocalDate.of(1980,
                                                     12,
                                                     12),
                                        85,
                                        180));

        customerMapLoc.put(null,
                           new Customer("ali",
                                        "veli",
                                        LocalDate.of(1980,
                                                     12,
                                                     12),
                                        85,
                                        180));

        customerMapLoc.put(null,
                           new Customer("test",
                                        "test",
                                        LocalDate.of(1980,
                                                     12,
                                                     12),
                                        85,
                                        180));

        customerMapLoc.putIfAbsent(null,
                           new Customer("test",
                                        "test",
                                        LocalDate.of(1980,
                                                     12,
                                                     12),
                                        85,
                                        180));
        // get
        Customer osmanLoc = customerMapLoc.get("osman1");

        System.out.println(osmanLoc);
        System.out.println("-----------------------------------");
        // iterate
        Collection<Customer> valuesLoc = customerMapLoc.values();
        for (Customer valueLoc : valuesLoc) {
            System.out.println(valueLoc);
        }

        Set<String> stringsLoc = customerMapLoc.keySet();
        for (String stringLoc : stringsLoc) {
            System.out.println(customerMapLoc.get(stringLoc));
        }

        Set<Map.Entry<String, Customer>> entriesLoc = customerMapLoc.entrySet();
        for (Map.Entry<String, Customer> entryLoc : entriesLoc) {
            System.out.println("Key : " + entryLoc.getKey() + " Value : " + entryLoc.getValue());
        }

    }
}
