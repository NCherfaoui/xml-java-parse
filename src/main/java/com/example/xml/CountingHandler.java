package com.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CountingHandler extends DefaultHandler {

    private int elementCount = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementCount++;
    }

    public int getElementCount() {
        return elementCount;
    }
}