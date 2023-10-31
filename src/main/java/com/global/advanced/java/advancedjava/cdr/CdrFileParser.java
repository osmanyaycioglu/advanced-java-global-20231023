package com.global.advanced.java.advancedjava.cdr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CdrFileParser extends Thread {
    private final CdrFileManager   cdrFileManager;
    private final CdrAppProperties cdrAppProperties;
    private final CdrManager cdrManager;

    public CdrFileParser(final CdrFileManager cdrFileManagerParam,
                         final CdrAppProperties cdrAppPropertiesParam,
                         final CdrManager cdrManagerParam) {
        cdrFileManager   = cdrFileManagerParam;
        cdrAppProperties = cdrAppPropertiesParam;
        cdrManager       = cdrManagerParam;
    }

    @Override
    public void run() {
        while (true) {
            String fileForProcessLoc = cdrFileManager.getFileForProcess();
            if (fileForProcessLoc != null) {
                Path pathLoc = Paths.get(cdrAppProperties.getCdrProcessDirectory(),
                                         fileForProcessLoc);
                try {
                    List<String> stringsLoc = Files.readAllLines(pathLoc);
                    cdrManager.addAllCdr(stringsLoc);
                    Thread.sleep(1);
                } catch (Exception eParam) {
                    eParam.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException eParam) {
                }
            }
        }
    }
}
