package com.global.advanced.java.advancedjava.cdr;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CdrFileManager {
    private BlockingQueue<String> filesToProcess = new ArrayBlockingQueue<>(1_000);

    public void addFile(String stringParam) {
        filesToProcess.add(stringParam);
    }

    public void addFiles(String... stringParam) {
        filesToProcess.addAll(Arrays.asList(stringParam));
    }

    public String getFileForProcess(){
        try {
            return filesToProcess.take();
        } catch (InterruptedException eParam) {
            return null;
        }
    }

}
