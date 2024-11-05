package com.example.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CreateDoc {

    public Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");

        Element author1 = root.addElement("author")
                .addAttribute("name", "James")
                .addAttribute("location", "UK")
                .addText("James Strachan");

        Element author2 = root.addElement("author")
                .addAttribute("name", "Bob")
                .addAttribute("location", "US")
                .addText("Bob McWhirter");

        return document;
    }

    public void writeDocumentToFile(Document document, String filePath) throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8")) {
            XMLWriter writer = new XMLWriter(outputStreamWriter, format);
            writer.write(document);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new IOException("Error writing document to file: " + e.getMessage(), e);
        }
    }
}