package com.global.advanced.java.advancedjava.cdr;

import com.global.advanced.java.advancedjava.java.properties.AppProperty;
import com.global.advanced.java.advancedjava.java.properties.GeneralPropRead;

public class CdrApp {

    public static void main(String[] args) {
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

    }

}
