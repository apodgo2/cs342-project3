/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * This class will contain all necessary classes needed to perform 
 * calculations on arrays of integers.
 * 
 */

public class HUI {
 
 public int[] storage;
 
 public HUI(String fileinput) {
  storage = stringToArray(fileinput);
 }
 public HUI(int[] input) {
   storage = input;
 }
 
 //determines if the given int array is a valid integer decimal array
 public static boolean isInt(int[] x)
 {
  int i=0;
  for (i = 0; i < x.length; i++)
  {
   if( (x[i] < 0) || (x[i] > 9))
   {
    return false;
   }
  }
  return true;
 }
 //determines if THIS HUI INSTANCE is valid
 public boolean isInt() {
   if (isInt(storage)) {
     return true;
   } else {
     return false;
   }
 }
 
 //adds an HUI to this HUI
 public void add(HUI toAdd)
 {
  this.storage = arrayAdd(this.storage, toAdd.getArray());
 }
 //adds HUI b to HUI a and returns the resultant HUI
 public static HUI add(HUI a, HUI b)
 {
  return new HUI(arrayAdd(a.getArray(), b.getArray())); 
 }
 
 //subtracts an HUI from this HUI
 public void sub(HUI toSub)
 {
  this.storage = arraySub(this.storage, toSub.getArray());
 }
 //subtracts HUI b from HUI a and returns the resultant HUI
 public static HUI sub(HUI a, HUI b)
 {
  return new HUI(arraySub(a.getArray(), b.getArray()));
 }
 
 public static int[] stringToArray(String input)
 {
  int[] temp = new int[1];
  int currentInt;
  int currentIndex = 0;
  int currentChar = input.length();
  do
  {
   currentInt = Character.getNumericValue(input.charAt(--currentChar));
   temp[currentIndex++] = currentInt;
   if (currentChar > 0)
   {
    temp = arrayIncreaseSize(temp);
   }
   
  }while(currentChar > 0);
  
  
  return temp;
 }
 
 public static int[] intToArray(double input)
 {
  if (input < 0)
  {
   // Exit with an error message.
  }
  int[] temp = new int[1];
  int currentInt;
  int currentIndex = 0;
  
  do
  {
   currentInt = (int)input % 10;
   temp[currentIndex++] = currentInt;
   //System.out.printf("Current Int is %d\n", currentInt);

   input = input / 10;
   if (input >= 1)
   {
    //System.out.printf("Increasing size.\n");
    temp = arrayIncreaseSize(temp);
   }
  }while (input >= 1);
  
  return temp;
 }
 
 private static int[] arrayIncreaseSize(int[] input)
 {
  int arraySize = input.length;
  int[] newArray = new int[arraySize+1];
  for (int i = 0; i < arraySize; i++)
  {
   //System.out.printf("Copying %d to index array %d\n", input[i], i);
   newArray[i] = input[i];
  }
  return newArray;
 }

 public static int[] arrayAdd(int[] x, int[] y)
 {
  int[] temp = new int[1];
  int currentIndexX = 0;
  int currentIndexY = 0;
  int currentIndexT = 0;
  int currentIntX = 0;
  int currentIntY = 0;
  int currentSum = 0;
  int carryInt = 0;
  do
  {
   System.out.printf("Current stats, currentX: %d, currentY: %d, carryInt; %d\n", currentIndexX, currentIndexY, carryInt);
   if (currentIndexX < (x.length))
   {
    currentIntX = x[currentIndexX];
    System.out.printf("Updating currentIntX: %d, length of x: %d\n", currentIntX, x.length);
    if ((currentIntX > 9) || (currentIntX < 0))
    {
     System.out.printf("Not an integer: %d\n", currentIntX); 
     // Exit to do
    }
   }
   else if (currentIndexX >= (x.length))
   {
    System.out.printf("CurrentIntX is out of range.\n");
    currentIntX = 0;
   }
   if (currentIndexY < (y.length))
   {
    System.out.printf("Updating currentIntY.\n");
    currentIntY = y[currentIndexY];
    if ((currentIntY > 9) || (currentIntY < 0))
    {
     System.out.printf("Not an integer: %d\n", currentIntY); 
     // Exit to do
    }
   }
   else if (currentIndexY >= (y.length))
   {
    System.out.printf("CurrentIntY is out of range.\n");
    currentIntY = 0;
   }
   
   currentSum = currentIntX + currentIntY + carryInt;

   if (currentSum < 10)
   {
    carryInt = 0;
   }
   else if (currentSum > 9)
   {
    System.out.printf("Carrying over, currentSum: %d, currentY: %d, carryInt; %d\n", currentSum, currentIndexY, carryInt);
    carryInt = 1;
    currentSum = currentSum - 10;
    System.out.printf("Done carrying over, currentSum: %d, carryInt; %d\n", currentSum, carryInt);

   }
   temp[currentIndexT] = currentSum;
   currentIndexT++;
   currentIndexX++;
   currentIndexY++;
   if ((currentIndexX < (x.length)) || (currentIndexY < (y.length)) || (carryInt != 0))
   {
    //System.out.printf("Increasing size, currentX: %d, currentY: %d, carryInt; %d\n", currentIndexX, currentIndexY, carryInt);
    temp = arrayIncreaseSize(temp);
   }
   
   
  }while((currentIndexX < (x.length)) || (currentIndexY < (y.length)) || (carryInt != 0));
  
  return temp;
 }

  public static int[] arraySub(int[] x, int[] y)
 {
  if (arrayIsEqual(x,y) == -1)
  {
   int[] temp = new int[1];
   temp[0] = -1;
   //throw an exception
   return temp;
  }
  else if (arrayIsEqual(x,y) == 0)
  {
   //numbers are equals
   int[] temp = new int[1];
   temp[0] = 0;
   
   return temp;
  }
  int[] temp = new int[1];
  int currentIndexX = 0;
  int currentIndexY = 0;
  int currentIndexT = 0;
  int currentIntX = 0;
  int currentIntY = 0;
  int currentSum = 0;
  int carryInt = 0;
  //for (int i = 0; i < x.length; i++)
  //{
   //System.out.printf("Index of X %d, is %d\n", i, x[i]);
  //}
  do
  {
   if (currentIndexX < (x.length))
   {
    if ((x[currentIndexX] > 9) || (x[currentIndexX] < 0))
    {
     System.out.printf("X Not an integer: %d %d %d\n", currentIntX, currentIndexX, x.length); 
     // Exit to do
    }
    else
    {
     currentIntX = x[currentIndexX];

    }
   }
   else if (currentIndexX >= (x.length))
   {
    //System.out.printf("CurrentIntX is out of range.\n");
    currentIntX = 0;
   }
   if (currentIndexY < (y.length))
   {
    currentIntY = y[currentIndexY];
    //System.out.printf("Updating currentIntY: %d.\n", currentIntY);
    if ((currentIntY > 9) || (currentIntY < 0))
    {
     System.out.printf("Y Not an integer: %d\n", currentIntY); 
     // Exit to do
    }
   }
   else if (currentIndexY >= (y.length))
   {
    //System.out.printf("CurrentIntY is out of range.\n");
    currentIntY = 0;
   }
   //System.out.printf("Updating carryInt: %d.\n", carryInt);
   currentSum = currentIntX - currentIntY - carryInt;
   //System.out.printf("Current Sum: %d.\n", currentSum);

   if (currentSum > -1)
   {
    carryInt = 0;
   }
   else if ((currentSum < 0) && ((currentIndexY < y.length) || (currentIndexX < x.length)) )
   {
    //System.out.printf("Carrying over, currentSum: %d, currentYIndex: %d %d, currentXIndex: %d %d, carryInt; %d\n", currentSum, currentIndexY, y.length, currentIndexX, x.length, carryInt);
    carryInt = 1;
    currentSum = currentSum + 10;
    //System.out.printf("Done carrying over, currentSum: %d, carryInt; %d\n", currentSum, carryInt);

   }
   else 
   {
    //exit here
    carryInt = 0;
    System.out.printf("Answer is negative\n");

   }
   temp[currentIndexT] = currentSum;
   currentIndexT++;
   currentIndexX++;
   currentIndexY++;
   if ((currentIndexX < (x.length)) || (currentIndexY < (y.length)) || (carryInt != 0))
   {
    //System.out.printf("Increasing size, currentX: %d %d, currentY: %d %d, carryInt; %d\n", currentIndexX, x.length, currentIndexY,y.length, carryInt);
    temp = arrayIncreaseSize(temp);
   }
   
   
  }while((currentIndexX < (x.length)) || (currentIndexY < (y.length)) || (carryInt != 0));
  return temp;
 }

public static int[] arrayMul(int[] x, int[] y)
 {
  int[] temp = new int[1];
  temp[0] = 0;
  
  if ( (arrayIsEqual(x, temp) == 0) || (arrayIsEqual(y,temp) == 0) )
  {
   // throw an exception
   return temp;
  }
  System.out.printf("Not multiplying by zero.\n");
  temp = new int[x.length + y.length];
  int indexX,indexY, carryInt;
  for (indexX = 0; indexX < x.length; indexX++)
  {
   carryInt = 0;
   for (indexY = 0; indexY < y.length; indexY++)
   {
    temp[indexX + indexY] += carryInt + (x[indexX] * y[indexY]);
    if (temp[indexX + indexY] > 9)
    {
     //System.out.printf("Carrying an int.\n");
     carryInt = temp[indexX + indexY] / 10;
     temp[indexX + indexY] = temp[indexX + indexY] - (10*carryInt);
    }
    else
    {
     carryInt = 0;
    }
   }
  temp[indexX + y.length] += carryInt;
   
  }
  
  
  return temp;
 }

//multiply our storage by the toMulBy storage.
public void mul(HUI toMulBy) {
  this.storage = arrayMul(this.storage, toMulBy.getArray());
}


 private static int[] arrayCopy(int[] x)
 {
  int[] temp = new int[x.length];
  for (int i = 0; i < x.length; i++)
  {
   temp[i] = x[i];
  }
  return temp;
 }
 
 private static int[] shiftLeft(int[] x)
 {
  int[] temp = new int[x.length+1];
  temp[0] = 0;
  for(int i = 0; i < x.length; i++)
  {
   temp[i+1] = x[i];
  }
  return temp;
 }
 
public int[] arrayDiv(int[] divident, int[] divisor)
 {

  int[] quotient = new int[1];
  quotient[0] = 0;
  int[] remainder = new int[0];

  //assumption: if the user inputs [0,0,0,0,0,0,0] as the divisor this function will fail
  if ((divisor.length == 1) && (divisor[0] == 0))
  {
   //Can't divide by zero. throw exception
   return quotient;
  }
  int i,k;
  for(i = divident.length-1,k=0; i >= 0; i--,k++)
  {
   //arrayIncreaseSize(remainder);
   remainder = shiftLeft(remainder);
   quotient = arrayIncreaseSize(quotient);
   remainder[0] = divident[i];
   //System.out.printf("1 remainder length: %d, divisor length: %d: isEqual: %d\n", remainder.length, divisor.length, arrayIsEqual(remainder,divisor));

   //for (int k = 0; k < remainder.length; k++)
   //{
    //System.out.printf("remainder in div index: %d, value %d, i: %d, length: %d\n", k, remainder[k], i, divident.length);
   //}
   //System.out.printf("remainder length: %d - %d, divisor length: %d: isEqual: %d\n", remainder.length,remainder[0], divisor.length, arrayIsEqual(remainder,divisor));

   while(arrayIsEqual(remainder,divisor)!= -1)
   {
    //System.out.printf("While remainder length: %d, divisor length: %d: isEqual: %d\n", remainder.length, divisor.length, arrayIsEqual(remainder,divisor));
    remainder = arraySub(remainder,divisor);
    quotient[k] = quotient[k] + 1;
    //System.out.printf("Quotient[i]: %d, remainder: %d: %d-%d\n",quotient[i], remainder[0], divisor[1],divisor[0]);

   }
   
  }
  return remainder;
 }

 public static int[] arrayMod(int[] x, int[] y)
 {
  int[] temp = new int[y.length];
  int[] temp2 = arrayCopy(x);
  
  while(arrayIsEqual(temp2,y) != -1)
  {
   temp2 = arraySub(temp2,y);
  }
  for (int i = 0; i < x.length; i++)
  {
   temp[i] = temp2[i];
  }
  return temp;
 }
 //modulos this with toMod
 public void mod(HUI toMod) {
   this.storage = arrayMod(this.storage, toMod.getArray());
 }
 
public static int arrayIsEqual(int[] x, int[] y)
 {
  int diff = x.length-1;
  if (x.length > y.length) 
  {
   diff = y.length-1;
   int i;
   for (i = x.length-1; (i > 0) || (i > y.length); i--)
   {
    if ( x[i] > 0)
    {
     return 1;
    }
   }
  }
  else if (x.length < y.length)
  {
   diff = x.length-1;
   int i;
   for (i = y.length-1; (i > 0) || (i > x.length); i--)
   {
    if ( y[i] > 0)
    {
     return -1;
    }
   }  
  }
  int i;
  for (i = diff; i >= 0; i--)
  {
   if (x[i] > y[i])
   {
    return 1;
   }
   else if (x[i] < y[i])
   {
    return -1;
   }
  }
  //System.out.printf("Returning in else\n");
  return 0;

 }
 
 public String toString() {
   String ret = "";
   for (int x : storage) {
     ret += x;
   }
   return ret;
 }
 
 //getters and setters
 public int[] getArray() {
  return storage;
 }

 //returns true if there is only zeroes in HUI
 public boolean isZero() {
   for (int x : storage) {
     if (x != 0) {
       return false;
     }
   }
   return true;
 }
 
 //TODO: OPTIMIZE THIS WITH THE ALGORITHM FROM THE WRITEUP
 public static HUI exponentiate(HUI base, HUI exponent) {
   while(exponent.isZero() != true) {
     exponent.sub(new HUI("1"));//subtract one from exponent until it's zero.
     base.mul(base);
   }
   return base;
 }
 
}
