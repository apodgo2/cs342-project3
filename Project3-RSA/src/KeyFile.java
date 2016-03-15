/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * Block class
 * This is the class that will allow the RSA computation to deal with smaller numbers
 */

//Apparently keyfiles are in XML. :/

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.swing.JOptionPane;

public class KeyFile extends InputFile {
  DocumentBuilderFactory factory;
  DocumentBuilder builder;
  HUI p1; HUI p2;
  boolean isPublicKey = false;//determine type of primes we're working with

 public KeyFile(String path, boolean isPublicKey) throws IOException {
  super(path);
  this.isPublicKey = isPublicKey;
  //build our XML parsing equipment
  try {
    this.factory = DocumentBuilderFactory.newInstance();
    this.builder = factory.newDocumentBuilder();
  } catch (ParserConfigurationException e) {
     e.printStackTrace();
  }
  parse();
 }
 
 @Override
 public void parse() {
   try {
     Document doc = builder.parse(this.file);
     doc.getDocumentElement().normalize();
     NodeList nList = doc.getDocumentElement().getChildNodes();
     
     if (isPublicKey) {
       String val1 = getNodeValue("evalue", nList);
       String val2 = getNodeValue("nvalue", nList);
       if (val1 != null && val2 != null) {
         //parse public key XML into HUI
         p1 = new HUI(val1);
         p2 = new HUI(val2);
       } else {
         JOptionPane.showMessageDialog(MainWindow.getInstance().getFrame(), "Your keyfile is formatted incorrectly.");
       }
     } else {
       String val1 = getNodeValue("dvalue", nList);
       String val2 = getNodeValue("nvalue", nList);
       if (val1 != null && val2 != null) {
         //parse private key XML into HUI
         p1 = new HUI(val1);
         p2 = new HUI(val2);
       } else {
         JOptionPane.showMessageDialog(MainWindow.getInstance().getFrame(), "Your keyfile is formatted incorrectly.");
       }
     }
     
     //validate our HUI's.
     if (!(p1.isInt() && p2.isInt())) {
       JOptionPane.showMessageDialog(MainWindow.getInstance().getFrame(), "Your keyfile values are formatted incorrectly, or are not valid decimal integers.");
       p1 = p2 = null;
     }
     
   } catch (SAXException e) {
     e.printStackTrace();
   } catch (IOException e) {
     e.printStackTrace();
   }
 }
 
 public HUI getPrime1() {
  return p1;
 }
 public HUI getPrime2() {
  return p2;
 }
 
 public boolean isPublicKey() {
   return isPublicKey;
 }
 
 protected String getNodeValue(String tagName, NodeList nodes ) {
    for ( int x = 0; x < nodes.getLength(); x++ ) {
        Node node = nodes.item(x);
        if (node.getNodeName().equalsIgnoreCase(tagName)) {
            NodeList childNodes = node.getChildNodes();
            for (int y = 0; y < childNodes.getLength(); y++ ) {
                Node data = childNodes.item(y);
                if ( data.getNodeType() == Node.TEXT_NODE )
                    return data.getNodeValue();
            }
        }
    }
    return "";
}
 
}
