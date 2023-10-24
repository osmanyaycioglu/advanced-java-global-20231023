package com.global.advanced.java.advancedjava.java.generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String model;
    private Integer year;
    private int horsePower;
}
