package com.global.advanced.java.advancedjava.java.parsers;

import com.global.advanced.java.advancedjava.models.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParser {
    public static void main(String[] args) throws Exception {
        Customer customerLoc = Customer.builder()
                                       .withFirstName("ali")
                                       .withLastName("veli")
                                       .withWeight(120)
                                       .withHeight(180)
                                       .build();

        JAXBContext jaxbContextLoc = JAXBContext.newInstance(Customer.class);
        Marshaller  marshallerLoc  = jaxbContextLoc.createMarshaller();
        marshallerLoc.marshal(customerLoc,
                              System.out);
        File fileLoc = new File("./src/main/resources/data/customer.xml");
        Unmarshaller unmarshallerLoc = jaxbContextLoc.createUnmarshaller();
        Customer unmarshalLoc = (Customer) unmarshallerLoc.unmarshal(fileLoc);
        System.out.println("debneme");
        System.out.println("Customer : " + unmarshalLoc);

    }
}
