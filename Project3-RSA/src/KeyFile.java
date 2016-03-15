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

public class KeyFile extends InputFile {
  DocumentBuilderFactory factory;
  DocumentBuilder builder;
  HUI p1; HUI p2;
  boolean isPublicKey = false;//determine type of primes we're working with

 public KeyFile(String path, boolean isPublicKey) {
  super(path);
  this.isPublicKey = isPublicKey;
  //build our XML parsing equipment
  try {
    this.factory = DocumentBuilderFactory.newInstance();
    this.builder = factory.newDocumentBuilder();
  } catch (ParserConfigurationException e) {
     e.printStackTrace();
  }
 }
 
 @Override
 public void parse() {
   try {
     if (isPublicKey) {
       Document doc = builder.parse(this.file);
       System.out.println("public rsakey evalue: "+doc.getElementById("rsakey").getAttribute("dvalue")+"rsakey nvalue: "+doc.getElementById("rsakey").getAttribute("nvalue"));
     } else {
       Document doc = builder.parse(this.file);
       System.out.println("private rsakey dvalue: "+doc.getElementById("rsakey").getAttribute("dvalue")+"rsakey nvalue: "+doc.getElementById("rsakey").getAttribute("nvalue"));
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
 
}
