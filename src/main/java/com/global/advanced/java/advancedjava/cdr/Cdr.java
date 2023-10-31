package com.global.advanced.java.advancedjava.cdr;

import lombok.Data;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Cdr {

    private String cdrId;
    private String msisdn;
    private long   cdrDateInMillis;
    private int    callDurationInSeconds;
    private int    cellId;
    private int    callRate;

    public List<Cdr> generateRandomCdr(SecureRandom secureRandomParam,
                                       int count) {
        long      msisdnLoc = Long.parseLong(msisdn);
        List<Cdr> cdrs      = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Cdr cdrLoc = new Cdr();
            cdrLoc.setCdrId(UUID.randomUUID()
                                .toString());
            cdrLoc.setMsisdn("" + (++msisdnLoc));
            cdrLoc.setCellId(secureRandomParam.nextInt(100));
            cdrLoc.setCallDurationInSeconds(secureRandomParam.nextInt(500));
            long lLoc = secureRandomParam.nextLong();
            cdrLoc.setCdrDateInMillis(System.currentTimeMillis() - lLoc);
            cdrLoc.setCallRate(callRate);
            cdrs.add(cdrLoc);
        }
        return cdrs;
    }

    public String toCsv() {
        return cdrId
               + ","
               + msisdn
               + ","
               + cdrDateInMillis
               + ","
               + callDurationInSeconds
               + ","
               + cellId
               + ","
               + callRate;
    }

}
