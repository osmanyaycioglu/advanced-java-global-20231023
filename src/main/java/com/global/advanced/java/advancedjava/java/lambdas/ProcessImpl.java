package com.global.advanced.java.advancedjava.java.lambdas;

public class ProcessImpl implements IProcess {

    @Override
    public String execute(final Integer count,
                          final String data) {
        return "Data : " + data + " count : " + count;
    }

}
