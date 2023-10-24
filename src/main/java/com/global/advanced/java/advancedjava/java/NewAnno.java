package com.global.advanced.java.advancedjava.java;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,
         ElementType.FIELD
})
public @interface NewAnno {
    String value();

    int count() default 1;
}
