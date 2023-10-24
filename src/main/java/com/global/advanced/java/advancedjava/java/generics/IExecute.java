package com.global.advanced.java.advancedjava.java.generics;

public interface IExecute<T extends Car, R> {

    R execute(T t);

    boolean checkRule(T t);

    default void show(T t) {
        System.out.println("model : " + t.getModel());
    }

}
