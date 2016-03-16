/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * RSA Class
 * This is the main class for all our RSA algorithm computations.
 */


public class RSA {
  HUI p; //prime #1
  HUI q; //prime #2
  HUI n; //p*q
  int phi; //Euler Totient Function, derived from p,q using Extended Euclidian Algo.
  HUI e; //Ósome arbitrary number that is less than n and relatively prime to ?(phi)Ó
  HUI d; //satisfies (e * d) mod = 1
  
  public RSA(HUI p, HUI q) {
    this.p = p;
    this.q = q;
    this.n = new HUI(HUI.arrayMul(p.getArray(), q.getArray()));
  }
  
  //public Block processBlock(Block b, HUI exp) {
  //  b.getArray
  //}
  
  public HUI getQ() {
    return q;
  }
  public HUI getP() {
    return p;
  }
  public HUI getN() {
    return n;
  }
  public int getPhi() {
    return phi;
  }
  public HUI getE() {
    return e;
  }
  public HUI getD() {
    return d;
  }
  
}
