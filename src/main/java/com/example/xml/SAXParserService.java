package com.example.xml;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class SAXParserService {

    public void parseXmlFile(String filePath) throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MySAXHandler handler = new MySAXHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource(new FileInputStream(filePath)));
    }

    public int countElementsInXmlFile(String filePath) throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        CountingHandler handler = new CountingHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource(new FileInputStream(filePath)));
        return handler.getElementCount();
    }
}