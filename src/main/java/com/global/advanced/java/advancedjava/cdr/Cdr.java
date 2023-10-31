package com.global.advanced.java.advancedjava.cdr;

import lombok.Data;

@Data
public class Cdr {

    private String cdrId;
    private String msisdn;
    private long   csrDateInMillis;
    private int    callDurationInSeconds;
    private int    cellId;
    private int    callRate;

}
