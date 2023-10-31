package com.global.advanced.java.advancedjava.cdr;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;

public class CdrDirectoryWatcher extends Thread {
    private final CdrAppProperties cdrAppProperties;
    private final CdrFileManager   cdrFileManager;

    public CdrDirectoryWatcher(final CdrAppProperties cdrAppPropertiesParam,
                               final CdrFileManager cdrFileManagerParam) {
        cdrAppProperties = cdrAppPropertiesParam;
        cdrFileManager   = cdrFileManagerParam;
    }

    @Override
    public void run() {
        SecureRandom secureRandomLoc = new SecureRandom();
        File         fileLoc         = new File(cdrAppProperties.getCdrDirectory());
        Path         sourceLoc       = Paths.get(fileLoc.toURI());
        boolean      existsLoc       = fileLoc.exists();
        if (!existsLoc) {
            try {
                Files.createDirectory(sourceLoc);
            } catch (IOException eParam) {
                System.exit(5);
            }
        }
        Path destinationLoc = Paths.get(cdrAppProperties.getCdrProcessDirectory());
        while (true) {
            try {
                Thread.sleep(cdrAppProperties.getCdrDirectoryWatchPeriod());
                String[] listLoc = fileLoc.list();
                for (String stringLoc : listLoc) {
                    String destFile = System.currentTimeMillis()
                                      + "_"
                                      + secureRandomLoc.nextInt()
                                      + "_"
                                      + stringLoc;
                    Files.move(sourceLoc.resolve(stringLoc),
                               destinationLoc.resolve(destFile),
                               StandardCopyOption.REPLACE_EXISTING);
                    cdrFileManager.addFiles(destFile);
                }
            } catch (Exception eParam) {
                eParam.printStackTrace();
            }
        }
    }
}
