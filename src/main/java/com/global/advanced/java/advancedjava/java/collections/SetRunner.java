package com.global.advanced.java.advancedjava.java.collections;

import com.global.advanced.java.advancedjava.models.Customer;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class SetRunner {
    public static void main(String[] args) {

        ConcurrentHashMap.KeySetView<String, Boolean> objectsLoc = ConcurrentHashMap.newKeySet();


        Set<String> stringsLoc = new TreeSet<>();
        //Set<String> stringsLoc = new HashSet<>();
        stringsLoc.add("osman1");
        stringsLoc.add("osman2");
        stringsLoc.add("ali");
        stringsLoc.add("osman3");
        stringsLoc.add("osman4");
        stringsLoc.add("ali1");
        stringsLoc.add("osman5");
        stringsLoc.add("osman6");
        stringsLoc.add("ali2");
        stringsLoc.add("osman7");
        stringsLoc.add("osman8");
        stringsLoc.add("ali3");

        boolean containsLoc = stringsLoc.contains("osman1");

        for (String stringLoc : stringsLoc) {
            System.out.println(stringLoc);
        }

        System.out.println(stringsLoc);

        Set<Customer> customersLoc = new TreeSet<>();

        Set<String> k1 = new HashSet<>();
        k1.add("1");
        k1.add("2");
        k1.add("3");
        k1.add("4");
        k1.add("5");

        Set<String> k2 = new HashSet<>();
        k2.add("4");
        k2.add("5");
        k2.add("6");
        k2.add("7");
        k2.add("8");
        k2.add("9");

        Set<String> k3 = new HashSet<>(k1);
        k3.retainAll(k2);
        System.out.println("kesişim : " + k3);

        Set<String> k4 = new HashSet<>(k1);
        k4.removeAll(k2);
        System.out.println("fark : " + k4);

        Set<String> k5 = new HashSet<>(k1);
        k5.addAll(k2);
        System.out.println("birleşim : " + k5);

    }
}
