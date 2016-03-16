/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * RSA Class
 * This is the main class for all our RSA algorithm computations.
 */


public class RSA {
  protected HUI p; //prime #1
  protected HUI q; //prime #2
  protected HUI n; //p*q
  protected HUI phi; //Euler Totient Function, derived from p,q using Extended Euclidian Algo.
  protected HUI e; //Ósome arbitrary number that is less than n and relatively prime to ?(phi)Ó
  protected HUI d; //satisfies (e * d) mod = 1
  
  //this constructor is called when the user generates or specifies their own primes (still gotta add this one to the GUI handlers.)
  public RSA(HUI p, HUI q) {
    this.p = p;
    this.q = q;
    this.n = new HUI(HUI.arrayMul(p.getArray(), q.getArray()));
    //TODO: calculate phi, calculate e, calculate d
    //this.phi = 
  }
  
  //This constructor is called when the user loads their own key files (code already in GUI class) DONE! just need to fill out the constructor, see line 133 of MainWindow
  public RSA(KeyFile privateKey, KeyFile publicKey) {
    //TODO: calculate all variables
  }
  
  
  //This is where all the encryption happens
  public Block processBlock(Block b, HUI exp) {
    //C = M^e mod n
    return new Block(new HUI(HUI.arrayMod(HUI.exponentiate(b.getHUI(), exp).getArray(), n.getArray())));
  }
  
  public HUI getQ() {
    return q;
  }
  public HUI getP() {
    return p;
  }
  public HUI getN() {
    return n;
  }
  public HUI getPhi() {
    return phi;
  }
  public HUI getE() {
    return e;
  }
  public HUI getD() {
    return d;
  }
  
}
