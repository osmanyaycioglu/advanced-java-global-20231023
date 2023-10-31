package com.global.advanced.java.advancedjava.java.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.advanced.java.advancedjava.models.Customer;

import java.io.File;
import java.io.IOException;

public class jsonParser {
    public static void main(String[] args) {
        ObjectMapper objectMapperLoc = new ObjectMapper();
        File         fileRootLoc     = new File("./");
        String       absolutePathLoc = fileRootLoc.getAbsolutePath();
        System.out.println(absolutePathLoc);
        String[] listLoc = fileRootLoc.list();
        for (String stringLoc : listLoc) {
            System.out.println(stringLoc);
        }
        // File fileLoc = new File("./src/main/resources/data/customer.json");
        File fileLoc = new File("./src/main/resources/data/customer.json");
        try {
            Customer customerLoc = objectMapperLoc.readValue(fileLoc,
                                                             Customer.class);
            System.out.println(customerLoc);
        } catch (IOException eParam) {
            eParam.printStackTrace();
        }
        Customer customerLoc = Customer.builder()
                                       .withFirstName("ali")
                                       .withLastName("veli")
                                       .withWeight(120)
                                       .withHeight(180)
                                       .build();
        try {
            String stringLoc = objectMapperLoc.writeValueAsString(customerLoc);
            System.out.println(stringLoc);
        } catch (JsonProcessingException eParam) {
            eParam.printStackTrace();
        }
    }

}
