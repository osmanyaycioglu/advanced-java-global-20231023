package com.global.advanced.java.advancedjava.java.lambdas;

@FunctionalInterface
public interface ITest<T, R> {

    R testExec(T str);
}
