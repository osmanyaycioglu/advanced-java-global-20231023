package com.global.advanced.java.advancedjava.java.properties;

import com.global.advanced.java.advancedjava.java.Property;
import com.global.advanced.java.advancedjava.java.PropertyFile;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@PropertyFile("src/main/resources/my.properties")
@Component
@ConfigurationProperties(prefix = "deneme.app")
public class AppProperty {
    @Property("deneme.app.name")
    private String  appName;
    @Property("deneme.app.test.version")
    private String  testVersion;
    @Property("deneme.app.db.url")
    private String  dbUrl;
    @Property("deneme.app.db.username")
    private String  dbUsername;
    @Property("deneme.app.db.password")
    private String  dbPassword;
    @Property("deneme.app.port")
    private Integer appPort;

}
