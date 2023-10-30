package com.global.advanced.java.advancedjava.java.enums;

public class EnumRunner {
    public static void main(String[] args) {
        EState eStateLoc = EState.STOPPED;
        System.out.println(eStateLoc.check());
        System.out.println(eStateLoc.load("customer.txt"));
        switch (eStateLoc) {
            case BOOTING:
                break;
            case RUNNING:
                break;
            case PAUSED:
                break;
            case STOPPED:
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + eStateLoc);
        }

        int stateVal = 0;
        switch (stateVal) {
            case IJavaCodeData.SYSTEM_BOOT:
                break;
            case IJavaCodeData.SYSTEM_PAUSE:
                break;
            case IJavaCodeData.SYSTEM_RUN:
                break;
            case IJavaCodeData.SYSTEM_STOP:
                break;
            case 90:
                break;
            case IJavaCodeData.PROCESS_LIMIT:
                break;

        }
    }
}
