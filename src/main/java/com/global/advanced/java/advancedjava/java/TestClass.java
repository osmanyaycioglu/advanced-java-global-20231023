package com.global.advanced.java.advancedjava.java;

import lombok.*;

@NewAnno(value = "xyz", count = 2)
@MyFirstAnno(value1 = "osman", value2 = "yaycıoğlu")
@Data
public class TestClass extends Object {

    @NewAnno("abc")
    @MyFirstAnno(value1 = "xyz", value2 = "test1")
    private Integer integer1;
    private int     integer2;

    private String str1;
    private String str2;
    private String str3;
    private String str4;

    @MyFirstAnno(value1 = "xyz", value2 = "test1", value3 = "deneme")
    public String method(String name,
                         String surname) {
        return "OK " + name + " " + surname;
    }

}
