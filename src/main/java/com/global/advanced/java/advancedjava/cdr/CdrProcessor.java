package com.global.advanced.java.advancedjava.cdr;

public class CdrProcessor extends Thread {

    private final CdrManager cdrManager;
    private final CdrDb cdrDb;

    public CdrProcessor(final CdrManager cdrManagerParam,
                        final CdrDb cdrDbParam) {
        cdrManager = cdrManagerParam;
        cdrDb      = cdrDbParam;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String   stringLoc = cdrManager.takeCdr();
                String[] sa        = stringLoc.split(",");
                if (sa.length == 6 && isNumeric(sa[2]) && isNumeric(sa[3]) && isNumeric(sa[4]) && isNumeric(sa[5])) {
                    Cdr buildLoc = Cdr.builder()
                                      .withCdrId(sa[0])
                                      .withMsisdn(sa[1])
                                      .withCdrDateInMillis(Long.parseLong(sa[2]))
                                      .withCallDurationInSeconds(Integer.parseInt(sa[3]))
                                      .withCellId(Integer.parseInt(sa[4]))
                                      .withCallRate(Integer.parseInt(sa[5]))
                                      .build();
                    cdrDb.addCdrToBatch(buildLoc);
                }
            } catch (Exception eParam) {
                eParam.printStackTrace();
            }
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return strNum.chars()
                     .allMatch(ci -> ci >= '0' && ci <= '9');
    }
}
