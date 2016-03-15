/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * Input File class
 * Main class for all input classes
 */


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class InputFile {
 protected String path = "";
 protected String content = "";
 protected boolean isInvalid = false;
 protected boolean isWriteable = false;
 protected File file = null;

 public InputFile(String path) throws IOException {
  this.path = path;
  this.isWriteable = true;
  this.file = new File(path);
  read();
 }
 public InputFile(String path, boolean isWriteable) throws IOException {
  this.path = path;
  this.isWriteable = isWriteable;
  this.file = new File(path);
  read();
 }
 
 public void read() throws IOException {
   FileReader in = null;
   
   in = new FileReader(path);
   
   int c;
   while ((c = in.read()) != -1) {
     content += c;
   }
   if (in != null) {
     try {
       in.close();
     } catch (IOException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
     }
   }
 }
 
 public void write() {
  if (isWriteable) {
  FileWriter out = null;
     
  try {
   out = new FileWriter(path);
         
      out.write(content);
      } catch (IOException e) {
       System.out.println("You have specified an inappropriate filepath!");
    e.printStackTrace();
    path = null;
    content = null;
   }finally {
         if (out != null) {
            try {
     out.close();
    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
         }
      }
  }
 }
 
 public String getPath() {
  return path;
 }
 public String getContent() {
  return content;
 }
 protected void invalidate() {
  isInvalid = true;
 }
 public boolean isInvalid() {
  return isInvalid;
 }
 
 //override this:
 public void parse() {
   //This method is supposed to be overridden, so it just performs the same thing as Read in InputFile. Not useful for InputFile, but very useful in other classes.
   try {
     read();
   } catch (IOException e) {
     e.printStackTrace();
   }
 }
}
