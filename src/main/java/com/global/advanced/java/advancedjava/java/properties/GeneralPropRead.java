package com.global.advanced.java.advancedjava.java.properties;

import com.global.advanced.java.advancedjava.java.Property;
import com.global.advanced.java.advancedjava.java.PropertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class GeneralPropRead {

    public static void readProps(Object objectParam) throws Exception {
        // class object sini al
        Class<?> classLoc = objectParam.getClass();
        // class ın üzerindeki PropertyFile annotasyonunu al
        PropertyFile annotationLoc = classLoc.getAnnotation(PropertyFile.class);
        // annotasyon varsa işlem yap
        if (annotationLoc != null) {
            // propertyleri okuyacak class yarat ve property file ı oku
            Properties      propertiesLoc      = new Properties();
            File            fileLoc            = new File(annotationLoc.value());
            FileInputStream fileInputStreamLoc = new FileInputStream(fileLoc);
            propertiesLoc.load(fileInputStreamLoc);
            // class objesinden field bilgilerini al
            Field[] declaredFieldsLoc = classLoc.getDeclaredFields();
            // bütün field ları işle
            for (Field fieldLoc : declaredFieldsLoc) {
                //n field ların üzerindeki Property annotasyonlarını oku
                Property propAnnoLoc = fieldLoc.getAnnotation(Property.class);
                if (propAnnoLoc != null) {
                    // Property -> value bilgisini git okunan properties objesinden al
                    String propertyLoc = propertiesLoc.getProperty(propAnnoLoc.value());
                    if (propertyLoc != null && !propertyLoc.isEmpty()) {
                        // field access i aç private fieldlar için
                        fieldLoc.setAccessible(true);
                        // Field tipini al
                        Class<?> typeLoc = fieldLoc.getType();
                        // Field tipine göre farklı davran
                        if (typeLoc == String.class) {
                            // field ı set et
                            fieldLoc.set(objectParam,
                                         propertyLoc);
                        } else if (typeLoc == Integer.class) {
                            fieldLoc.set(objectParam,
                                         Integer.parseInt(propertyLoc));
                        }
                    }
                }
            }

        }

    }
}
