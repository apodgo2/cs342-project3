import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ResourceFile extends InputFile {
 protected ArrayList<HUI> primes = null;
 
 public ResourceFile(String path) throws IOException {
  super(path, false);
  primes = new ArrayList<HUI>(2);
  parse();
 }
 
 @Override
 public void parse() {
   BufferedReader br =null;
  try {
      br = new BufferedReader(new FileReader(path));
      String line;
      while ((line = br.readLine()) != null) {
         // process the line.
       primes.add(new HUI(line));
      }
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } finally {
    try {
      if (br != null) {
        br.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
 }
 
 public ArrayList<HUI> getPrimes() {
  return primes;
 }
 
 public HUI selectPrime() {
   Random gen = new Random();
   return primes.get(gen.nextInt(primes.size()));
 }
 //Supressing warnings because clone will always return a proper ArrayList or null.
 @SuppressWarnings("unchecked")
 public HUI selectPrime(HUI avoid) {
   Random gen = new Random();
   ArrayList<HUI> selections = (ArrayList<HUI>) primes.clone();
   selections.remove(avoid);
   return selections.get(gen.nextInt(selections.size()));
 }

}
