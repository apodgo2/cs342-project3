/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * Block class
 * This is the class that will allow the RSA computation to deal with smaller numbers
 */

public class Block {
 int length = 0;
 HUI storage = null;
 
 public Block(HUI in) {
  this.storage = in;
 }
 
 public HUI getHUI() {
  return storage;
 }
 
 public char[] getChars() {
  char[] builtChars = new char[(storage.getArray().length/2)+1];//0123456
  int currentIndex = 0;
  int charIndex = 0;
  int lastInt = -1;
  //get pairs of integers from array
  for (int x : storage.getArray()) {
   //if this is the second integer in a pair
   if (currentIndex % 2 != 0 && currentIndex != 0) {
    //add the character representation of the pair to our storage
    builtChars[charIndex] = (char) ((lastInt*10)+x);
    charIndex++;
   } else {
    //otherwise just store the first int of a pair
    lastInt = x;
   }
   currentIndex++;
  }
  return builtChars;
 }
}
