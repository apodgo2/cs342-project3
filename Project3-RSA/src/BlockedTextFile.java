/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * This class reperesents any kind of blocked file. This could be a plaintext file that's been blocked but not encrypted, or an encrypted file to be decrypted.
 * The user should type this information into the textbox to encrypt or decrypt text, which would be saved into a TextFile. that TextFile would then be converted into a BlockedTextFile using the constructor, then written to disk with write().
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class BlockedTextFile extends TextFile {
  
  ArrayList<Block> blocks = null;

 public BlockedTextFile(String path, int blocksize) throws IOException {//I defined the blocksize as a constant in Main. you should probably instead get it from the user somehow, but this is not necessary for our grade
  super(path);
  parse();
 }
 
 public BlockedTextFile(TextFile p) throws IOException {
   super(p.getPath());
 }
 
 //populates blocks with the information in 'content'
 @Override
 public void parse() {
   //TODO:
  //Convert inherited String variable "content" into the array of Blocks using the Blocking Algorithm as defined by the write-up
  //I've already created the deblocking algorithm, all you need to do is block and encrypt
   //for character in content, convert to ASCII equivalent integer HUI's, make those into Blocks, store them in our array.
   //make sure to enforce the block size, e.g., process 8 chars into one block, then make a new one. 
   //then all the other functions should work
   //good luck. - andrew

}

 public String deblock() {
   String unblockedText = "";
   for (Block b : blocks) {
     unblockedText += b.getChars();
   }
   return unblockedText;
 }
 
 public void encrypt() {
   ArrayList<Block> newblocks = new ArrayList<Block>(blocks.size());
   for (Block b : blocks) {
     newblocks.add(MainWindow.rsa.processBlock(b,MainWindow.rsa.getE()));
   }
   blocks = newblocks;
   //BlockedTextFile now contains encrypted blocks.
 }
 
  public void decrypt() {
   ArrayList<Block> newblocks = new ArrayList<Block>(blocks.size());
   for (Block b : blocks) {
     newblocks.add(MainWindow.rsa.processBlock(b,MainWindow.rsa.getD()));
   }
   blocks = newblocks;
   //BlockedTextFile now contains decrypted blocks.
 }
 
 /*
 public block() {
   parse();//this file is already blocked upon construction, so this function is unnecessary.
 }
 */
 
 public void write() {
   if (isWriteable) {
     FileWriter out = null;
     
     try {
       out = new FileWriter(path);
       for (Block b : blocks) {
         out.write(b.getChars()+"\n");//write each block to a file, one per line
       }
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
 
}