package com.global.advanced.java.advancedjava.java.generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair<A, B> {
    private A left;
    private B right;


    public boolean execute(Pair<A, B> pairParam) {
        System.out.println(pairParam + " -- " + this.toString());
        return true;
    }

    public void add(A a){

    }

}
