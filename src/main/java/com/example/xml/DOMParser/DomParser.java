package com.example.xml.DOMParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class DomParser {

    public Document loadDocument(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void readDocument(Document document) {
        Element root = document.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());

        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getNodeName() + ", Text: " + element.getTextContent());
            }
        }
    }
    public Document createDocument() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("root");
            document.appendChild(root);

            Element author1 = document.createElement("author");
            author1.setAttribute("name", "James");
            author1.setAttribute("location", "UK");
            author1.setTextContent("James Strachan");
            root.appendChild(author1);

            Element author2 = document.createElement("author");
            author2.setAttribute("name", "Bob");
            author2.setAttribute("location", "US");
            author2.setTextContent("Bob McWhirter");
            root.appendChild(author2);

            return document;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeDocumentToFile(Document document, String filePath) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
