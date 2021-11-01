package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        School school = new School(false, 2560, "Good School",
                new Student("Anton", "Antonov", 15), "geometry", "computer since");

        JAXBContext context = JAXBContext.newInstance(School.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(school, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            School result = (School) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
