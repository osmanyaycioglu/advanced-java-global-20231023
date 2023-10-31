package com.global.advanced.java.advancedjava.cdr;

import com.global.advanced.java.advancedjava.java.Property;
import com.global.advanced.java.advancedjava.java.PropertyFile;
import lombok.Data;

@Data
@PropertyFile("src/main/resources/my.properties")
public class CdrAppProperties {

    @Property("cdr.app.incoming.directory")
    private String cdrDirectory;

    @Property("cdr.app.process.directory")
    private String cdrProcessDirectory;


    @Property("cdr.app.directory.watch.period")
    private Long cdrDirectoryWatchPeriod;

}
