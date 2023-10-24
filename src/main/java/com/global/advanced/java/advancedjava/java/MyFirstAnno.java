package com.global.advanced.java.advancedjava.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RUNTIME)
@Target({ TYPE, FIELD,METHOD })
@Documented
public @interface MyFirstAnno {

    String value1();

    String value2();

    String value3() default "test";

    int value4() default 0;

    long value5() default 10L;

    Class<?> value6() default String.class;

    TimeUnit value7() default TimeUnit.DAYS;

    // SpringBootApplication value8();
}
