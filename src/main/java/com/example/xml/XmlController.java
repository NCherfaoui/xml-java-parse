package com.example.xml;

import org.dom4j.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import java.io.IOException;

@RestController
@RequestMapping("/api/xml")
public class XmlController {

    private final CreateDoc createDoc;
    private final SAXParserService saxParserService;

    public XmlController(CreateDoc createDoc, SAXParserService saxParserService) {
        this.createDoc = createDoc;
        this.saxParserService = saxParserService;
    }

    @GetMapping("/create")
    public String createXmlDocument() {
        Document document = createDoc.createDocument();
        System.out.print(document.asXML());
        return document.asXML();
    }

    @GetMapping("/write")
    public String writeXmlDocumentToFile() {
        Document document = createDoc.createDocument();
        String filePath = "output.xml";
        try {
            createDoc.writeDocumentToFile(document, filePath);
            return "Document written to " + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing document to file: " + e.getMessage();
        }
    }

    @GetMapping("/parse")
    public String parseXmlDocument() {
        String filePath = "output.xml";
        try {
            saxParserService.parseXmlFile(filePath);
            return "Document parsed successfully";
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return "Error parsing document: " + e.getMessage();
        }
    }

    @GetMapping("/count")
    public String countElementsInXmlDocument() {
        String filePath = "output.xml";
        try {
            int count = saxParserService.countElementsInXmlFile(filePath);
            return "Number of elements: " + count;
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return "Error counting elements: " + e.getMessage();
        }
    }
}