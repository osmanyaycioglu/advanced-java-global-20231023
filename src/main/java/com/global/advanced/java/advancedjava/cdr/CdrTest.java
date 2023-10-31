package com.global.advanced.java.advancedjava.cdr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CdrTest {
    public static void main(String[] args) {
        Path pathLoc = Paths.get("cdr1.txt");
        try {
            List<String> lines = Files.readAllLines(pathLoc);
            Map<String, Cdr> collectLoc = lines.stream()
                                               .map(line -> line.split(","))
                                               .filter(sa -> sa.length == 6)
                                               .filter(sa -> isNumeric(sa[2])
                                                             && isNumeric(sa[3])
                                                             && isNumeric(sa[4])
                                                             && isNumeric(sa[5]))
                                               .map(sa -> Cdr.builder()
                                                             .withCdrId(sa[0])
                                                             .withMsisdn(sa[1])
                                                             .withCdrDateInMillis(Long.parseLong(sa[2]))
                                                             .withCallDurationInSeconds(Integer.parseInt(sa[3]))
                                                             .withCellId(Integer.parseInt(sa[4]))
                                                             .withCallRate(Integer.parseInt(sa[5]))
                                                             .build())
                                               .collect(Collectors.toMap(Cdr::getMsisdn,
                                                                         cdr -> cdr));
            System.out.println(collectLoc);
        } catch (IOException eParam) {
            eParam.printStackTrace();
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long d = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
