package com.global.advanced.java.advancedjava.cdr;

public class CdrProcessor extends Thread {

    private final CdrManager cdrManager;

    public CdrProcessor(final CdrManager cdrManagerParam) {
        cdrManager = cdrManagerParam;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String stringLoc = cdrManager.takeCdr();
            } catch (Exception eParam) {
                eParam.printStackTrace();
            }
        }
    }
}
