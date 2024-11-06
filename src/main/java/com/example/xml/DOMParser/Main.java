package com.example.xml.DOMParser;

import org.w3c.dom.Document;

public class Main {
    public static void main(String[] args) {
        DomParser parser = new DomParser();

        // Créer et écrire un document XML
        Document document = parser.createDocument();
        parser.writeDocumentToFile(document, "output.xml");

        // Charger et lire un document XML
        Document loadedDocument = parser.loadDocument("output.xml");
        parser.readDocument(loadedDocument);


        // Évaluer des expressions XPath
        String expression = "/root/author[@name='James']";
        parser.evaluateXPath(loadedDocument, expression);

    }
}