package com.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandler extends DefaultHandler {

    @Override
     public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

}