package com.horsman.corejava;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class XmlTest {
    public static void main(String[] args) throws  Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File("F:\\ideaJava\\src\\com\\horsman\\corejava\\dom.xml");
        Document doc = builder.parse(file);

        Element root = doc.getDocumentElement();
        System.out.println(root.getChildNodes());
    }
}
