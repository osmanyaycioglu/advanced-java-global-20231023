package com.global.advanced.java.advancedjava.models;

import java.time.LocalDate;
import java.util.function.Supplier;

public class CustomerBuilderRun {
    public static void main(String[] args) {
        Customer customerLoc = Customer.builder()
                                       .withFirstName("osman")
                                       .withLastName("yay")
                                       .withBirthdate(LocalDate.now())
                                       .withWeight(100)
                                       .withHeight(200)
                                       .build();

        Customer customerLoc1 = new Customer();
        customerLoc1.setFirstName("osman");
        Supplier<String> stringSupplierLoc = () -> "ckdshjdck";
        String           stringLoc         = stringSupplierLoc.get();
        customerLoc1.setLastName("yay");
        customerLoc1.setBirthdate(LocalDate.now());
        customerLoc1.setWeight(100);
        customerLoc1.setHeight(200);
    }
}
