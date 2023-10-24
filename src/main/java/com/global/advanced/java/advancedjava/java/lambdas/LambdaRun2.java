package com.global.advanced.java.advancedjava.java.lambdas;

import java.util.function.*;

public class LambdaRun2 {
    public static void main(String[] args) {
        Consumer<String> consumerLoc = s -> System.out.println("test : " + s);
        BiConsumer<String, Integer> biConsumerLoc =(s, i) -> System.out.println("test : " + s + " " + i);

        Function<String, Integer> functionLoc = s -> Integer.parseInt(s);
        BiFunction<String,String,Integer> biFunctionLoc = (s1,s2) -> s1.length() + s2.length();
        UnaryOperator<String> unaryOperatorLoc = s -> s + "xyz";
        Function<String,String> unaryFunctionOperatorLoc = s -> s + "xyz";
        BinaryOperator<String> binaryOperatorLoc = (s1,s2) -> s1 + "-" + s2;
        BiFunction<String,String,String> binaryOperatorLoc2 = (s1,s2) -> s1 + "-" + s2;


        Predicate<String> predicateLoc = stringParam -> stringParam.length() > 4;
        BiPredicate<String,String> biPredicateLoc = (s1,s2) -> s1.length() > s2.length();

        Supplier<String> supplierLoc = () -> "deneme";

    }
}
