package com.global.advanced.java.advancedjava.cdr;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CdrManager {
    private BlockingQueue<String> cdrToProcess = new ArrayBlockingQueue<>(1_000_000);

    public void addAllCdr(List<String> cdrs){
        cdrToProcess.addAll(cdrs);
    }

    public String takeCdr() throws Exception {
        return cdrToProcess.take();
    }


}
