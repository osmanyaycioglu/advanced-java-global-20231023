package com.global.advanced.java.advancedjava.java.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadJavaProp {

    public static void main(String[] args) throws Exception {
        AppProperty appPropertyLoc = new AppProperty();
        GeneralPropRead.readProps(appPropertyLoc);
        System.out.println(appPropertyLoc);

    }


    public static void main2(String[] args) throws Exception {
        Properties propertiesLoc = new Properties();
        File fileLoc = new File("src/main/resources/my.properties");
        FileInputStream fileInputStreamLoc = new FileInputStream(fileLoc);
        propertiesLoc.load(fileInputStreamLoc);
        AppProperty appPropertyLoc = new AppProperty();

        appPropertyLoc.setAppName(propertiesLoc.getProperty("deneme.app.name"));
        appPropertyLoc.setTestVersion(propertiesLoc.getProperty("deneme.app.test.version"));
        appPropertyLoc.setDbUrl(propertiesLoc.getProperty("deneme.app.db.url"));
        appPropertyLoc.setDbUsername(propertiesLoc.getProperty("deneme.app.db.username"));
        appPropertyLoc.setDbPassword(propertiesLoc.getProperty("deneme.app.db.password"));
        appPropertyLoc.setAppPort(Integer.parseInt(propertiesLoc.getProperty("deneme.app.port")));
        System.out.println(appPropertyLoc);
    }


}
