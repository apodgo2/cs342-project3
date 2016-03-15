import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ResourceFile extends InputFile {
 protected ArrayList<HUI> primes;
 
 public ResourceFile(String path) throws IOException {
  super(path, false);
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

}
