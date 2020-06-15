import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Knuth's uniformly random permutation in linear time
 */
public class Shuffle {
   public static void shuffle(int[] a){
       int size = a.length;
       for (int i=0; i<size; i++){
           int currentValue = a[i];
           Random rand = new Random();
           // We have a random index from 0-i to keep it uniform
           int randomIndex = rand.nextInt(i+1);
           a[i] = a[randomIndex];
           a[randomIndex] = currentValue;
       }
   }
}
