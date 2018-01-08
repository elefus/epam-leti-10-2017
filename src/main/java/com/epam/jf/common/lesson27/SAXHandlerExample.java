package com.epam.jf.common.lesson27;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandlerExample extends DefaultHandler {

    private StringBuffer accumulator = new StringBuffer();
    private String servletName;
    private String servletClass;
    private String servletId;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        accumulator.setLength(0);
        if ("servlet".equals(qName)) {
            servletId = attributes.getValue("id");
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        accumulator.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "servlet-name":
                servletName = accumulator.toString().trim();
                break;

            case "servlet-class":
                servletClass = accumulator.toString().trim();
                break;

            case "servlet":
                System.out.println("Servlet " + servletName + ((servletId != null) ? " (id=" + servletId + ")" : "") + ": " + servletClass);
        }
    }

    @Override
    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw (exception);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended");
    }
}
