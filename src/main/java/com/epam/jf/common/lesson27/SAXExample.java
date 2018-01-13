package com.epam.jf.common.lesson27;

import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXExample {

    public static void main(String[] args) throws IOException, SAXException {
        SAXHandlerExample handler = new SAXHandlerExample();

        XMLReader parser = XMLReaderFactory.createXMLReader();
        parser.setFeature("http://xml.org/sax/features/validation", false);
        parser.setContentHandler(handler);
        parser.setErrorHandler(handler);
        InputSource input = new InputSource("web.xml");
        parser.parse(input);
    }
}
