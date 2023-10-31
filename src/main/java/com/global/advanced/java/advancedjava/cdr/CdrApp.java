package com.global.advanced.java.advancedjava.cdr;

import com.global.advanced.java.advancedjava.AdvancedJavaApplication;
import com.global.advanced.java.advancedjava.java.properties.GeneralPropRead;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class CdrApp {


    public static void main(String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(AdvancedJavaApplication.class,
                                                                          args);

        CdrAppProperties appPropertyLoc = new CdrAppProperties();
        try {
            GeneralPropRead.readProps(appPropertyLoc);
        } catch (Exception eParam) {
            System.out.println("Can not read properties");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException exParam) {
            }
            System.exit(0);
        }

        CdrFileManager cdrFileManagerLoc = new CdrFileManager();
        CdrDirectoryWatcher cdrDirectoryWatcherLoc = new CdrDirectoryWatcher(appPropertyLoc,
                                                                             cdrFileManagerLoc);
        cdrDirectoryWatcherLoc.setName("CDRDW");
        cdrDirectoryWatcherLoc.start();

        CdrManager cdrManagerLoc = new CdrManager();
        CdrDb cdrDbLoc = new CdrDb();
        for (int i = 0; i < 5; i++) {
            CdrFileParser cdrFileParserLoc = new CdrFileParser(cdrFileManagerLoc,
                                                               appPropertyLoc,
                                                               cdrManagerLoc);
            cdrFileParserLoc.setName("CDRFP-" + i);
            cdrFileParserLoc.start();
        }
        for (int i = 0; i < 20; i++) {
            CdrProcessor cdrProcessorLoc = new CdrProcessor(cdrManagerLoc,
                                                            cdrDbLoc);
            cdrProcessorLoc.setName("CDRProc-" + i);
            cdrProcessorLoc.start();
        }



    }

}
