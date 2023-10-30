package com.global.advanced.java.advancedjava.java.enums;

public class JavaCodeClass implements IJavaCodeData {

    public static void main(String[] args) {
        int a = INITIAL_VALUE;
        for (int i = 0; i < PROCESS_LIMIT; i++) {
            System.out.println(RUNNING);
            if (i == PROCESS_LIMIT - 1) {
                System.out.println(BITTI);
            }
        }

    }
}
