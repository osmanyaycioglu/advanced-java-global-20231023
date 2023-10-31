package com.global.advanced.java.advancedjava.cdr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class CdrGenerator {
    public static void main(String[] args) throws Exception {
        Cdr cdrLoc = new Cdr();
        cdrLoc.setMsisdn("5435550000");
        cdrLoc.setCallRate(10);

        List<Cdr> cdrsLoc = cdrLoc.generateRandomCdr(new SecureRandom(),
                                                     1_000);
        String collectLoc = cdrsLoc.stream()
                                   .map(cdr -> cdr.toCsv())
                                   .collect(Collectors.joining("\n"));
        Path pathLoc = Paths.get("cdr1.txt");
        Files.write(pathLoc,
                    collectLoc.getBytes(),
                    StandardOpenOption.CREATE_NEW);
    }
}
